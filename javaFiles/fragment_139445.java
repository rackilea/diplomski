@Value("${serverAddress}")
private String serverAddress;

@Bean
public GenericIMAPClient scanningIMAPClient() {
    if(serverAddress.equals("gmail.com"))
        return new GmailIMAPClient();
    else
        return new GenericIMAPClient();
}