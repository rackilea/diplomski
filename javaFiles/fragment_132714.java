package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "mail")
public class MailProperties {    
    private String host;
    private int port;
    private Smtp smtp;    
    //Getters & Setters

    public static class Smtp {    
        private boolean auth;
        private boolean starttlsEnable;    
        //Getters & Setters
    }
}