@MessageDriven(
messageListenerInterface = javax.jms.MessageListener.class,
name = "MyListener",
mappedName = "jms/my/notification",
activationConfig = {
    @ActivationConfigProperty(
        propertyName = "connectionFactoryJndiName",
        propertyValue = "weblogic.jms.XAConnectionFactory"),
    @ActivationConfigProperty(
        propertyName = "destinationType",
        propertyValue = "javax.jms.Queue")
})