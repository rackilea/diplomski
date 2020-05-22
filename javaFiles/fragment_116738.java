import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class HttpsConnector {

    @Value("${cert.keyStore}")
    private String keyStorePath;

    @Value("${cert.trustStore}")
    private String trustStorePath;

    @Value("${cert.keyStorePass}")
    private String keyStorePass;

    @Value("${cert.trustStorePass}")
    private String trustStorePass;

    @Value("${cert.keyStoreType}")
    private String keyStoreType;

    @Value("${cert.trustStoreType}")
    private String trustStoreType;

    @Value("${cert.keyAlias}")
    private String keyAlias;

    @Value("${cert.httpsPort}")
    private int httpsPort;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createSslConnector());
        return tomcat;
    }

    private Connector createSslConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();

        String absKeyStorePath = getAbsolutePath(keyStorePath);
        String absTrustStorePath = getAbsolutePath(trustStorePath);

        connector.setScheme("https");
        connector.setSecure(true);
        connector.setPort(httpsPort);
        protocol.setSSLEnabled(true);
        protocol.setKeystoreType(keyStoreType);
        protocol.setKeystoreFile(absKeyStorePath);
        protocol.setKeystorePass(keyStorePass);
        protocol.setTruststoreType(trustStoreType);
        protocol.setTruststoreFile(absTrustStorePath);
        protocol.setTruststorePass(trustStorePass);
        protocol.setKeyAlias(keyAlias);
        return connector;
    }

    private String getAbsolutePath(String path) {
        File file = new File(path);
        if (!file.isAbsolute()) {
            path = file.getAbsolutePath();
        }
        return path;
    }
}