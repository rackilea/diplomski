import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static final Logger LOGGER = LoggerFactory.getLogger(AppInitializer.class);
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[]{SpringWebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    FilterRegistration javaMelody = servletContext.getFilterRegistration("javamelody");
    if (javaMelody != null) {
      LOGGER.info("Java Melody Filter Registration found: {}", javaMelody);
      // Filter registered by Servlet Container via web-fragment in
      // javamelody.jar
      addFilter(javaMelody);
    } else {
      LOGGER.info("Java Melody Filter Registration not found. Registering dynamically");
      // Running in embedded server mode.
      FilterRegistration.Dynamic javaMelodyFilter = servletContext.addFilter("javamelody", new MonitoringFilter());
      addFilter(javaMelodyFilter);
    }
  }

  private void addFilter(FilterRegistration javaMelody) {
    javaMelody.addMappingForUrlPatterns(
            EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC), true, "/*");
    javaMelody.setInitParameter(Parameter.LOG.getCode(), Boolean.toString(false));
    javaMelody.setInitParameter(Parameter.DISPLAYED_COUNTERS.getCode(), "http,sql,error,log");
  }

}