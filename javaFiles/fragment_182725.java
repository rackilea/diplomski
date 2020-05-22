class MyManagedBean {

    @Resource(name="mail/Session") // this name is defined by your configuration
    private Session mailSession;


    public void someBusinessMethod() {
         ...
         Message message = new MimeMessage(mailSession);
         // compose message
         ...
         Transport.send(message);
    }

}