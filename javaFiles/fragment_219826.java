import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.xemantic.tadedon.guice.servlet.mock.FakeServletContainer;
import com.xemantic.tadedon.guice.servlet.mock.FakeServletContainerModule;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
public class FakeTestContainerInit {

    private final FakeServletContainer servletContainer;
    private final Injector internalInjector;
    private Subject internalSubject;

    public FakeTestContainerInit() {
        this(new Module[] {});
    }

    public FakeTestContainerInit(Module... modules) {
        super();

        modules = Arrays.copyOf(modules, modules.length + 1);
        modules[modules.length-1] = new FakeServletContainerModule();
        internalInjector = Guice.createInjector(modules);
        servletContainer = internalInjector.getInstance(FakeServletContainer.class);
    }

    public void start() throws ServletException, IOException {
        this.start(true);
    }

    public void start(boolean initializeSecurityContext) throws ServletException, IOException {

        getServletContainer().start();

        MockHttpServletRequest request = servletContainer.newRequest("GET","/");
        MockHttpServletResponse response = new MockHttpServletResponse();

        if(initializeSecurityContext) {
            SecurityManager scm = internalInjector.getInstance(SecurityManager.class);
            internalSubject = new WebSubject.Builder(scm, request, response).buildWebSubject();
            SubjectThreadState sts = new SubjectThreadState(internalSubject);
            sts.bind();
        } else { internalSubject = null; }

        getServletContainer().service(request, response);

    }

    public void stop() {
        servletContainer.stop();
    }

    public FakeServletContainer getServletContainer() {
        return servletContainer;
    }

    public <T> T getInstance(final Class<T> type) throws IOException, ServletException {
        return getServletContainer().getInstance(type);
    }

    public <T> T getInstance(final Key<T> key) throws IOException, ServletException {
        return getServletContainer().getInstance(key);
    }

    public Subject getSubject() {
        return internalSubject;
    }
}