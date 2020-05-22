@Bean
public UserDbAuthenticationFilter u3rAuthentication() { 
    return new UserDbAuthenticationFilter();
}

@Bean
public ResponseTextXmlFilter responseXmlFilter() { 
    return new ResponseTextXmlFilter();
}