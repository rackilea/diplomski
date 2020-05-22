import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put("PREFIX", "your text");
        return true;
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        MDC.clear();
    }
}

import com.tigerit.kai.education.util.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class BeanConfiguration {

   @Bean
   public LoggingInterceptor loggingHandlerInterceptor() {
      return new LoggingInterceptor();
   }

   @Bean
   public WebMvcConfigurerAdapter webConfigurer() {
      return new WebMvcConfigurerAdapter() {
         @Override
         public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loggingHandlerInterceptor());
         }
      };
   }
}