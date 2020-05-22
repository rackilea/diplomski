import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.Container;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.commons.lang3.reflect.FieldUtils;

public class TestFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        arg2.doFilter(arg0, arg1);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        ServletContext ctx = arg0.getServletContext();

        try {
            Object o = FieldUtils.readField(ctx, "context", true);
            StandardContext sCtx = (StandardContext) FieldUtils.readField(o, "context", true);
            Container container = (Container) sCtx;

            Container c = container.getParent();
        while (c != null && !(c instanceof StandardEngine)) {
            c = c.getParent();
        }

        if (c != null) {
            StandardEngine engine = (StandardEngine) c;
            for (Connector connector : engine.getService().findConnectors()) {
                // Get port for each connector. Store it in the ServletContext or whatever
                System.out.println(connector.getPort());
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}