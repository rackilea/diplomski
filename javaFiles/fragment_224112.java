import org.apache.catalina.valves.AbstractAccessLogValve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.io.CharArrayWriter;

/**
 * see https://www.baeldung.com/embeddedservletcontainercustomizer-configurableembeddedservletcontainer-spring-boot
 * 
*/
@Component
@Slf4j
public class CustomizeEmbeddedTomcatContainer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {

        log.info("configuring embedded Tomcat");
        TomcatSlf4jAccessValve accessLogValve = new TomcatSlf4jAccessValve();
        accessLogValve.setEnabled(true);

        /**
         * for pattern format see https://tomcat.apache.org/tomcat-7.0-doc/api/org/apache/catalina/valves/AccessLogValve.html
         */
        accessLogValve.setPattern("request: method=%m uri=\"%U\" response: statuscode=%s bytes=%b duration=%D(ms) client: remoteip=%a user=%u useragent=\"%{User-Agent}i\"");

        factory.addContextValves(accessLogValve);
    }


    public static class TomcatSlf4jAccessValve extends AbstractAccessLogValve {

        Logger httpAccessLogLogger = LoggerFactory.getLogger("http_access_log");

        @Override
        protected void log(CharArrayWriter message) {
            httpAccessLogLogger.info(message.toString());
        }

    }
}