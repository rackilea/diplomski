MyMessageListener ml = new MyMessageListener();
MessageConnection mc;
try {
    mc = (MessageConnection)Connector.open("sms://:0");
    mc.setMessageListener(el);
} catch (Exception e) {
    // handle exception
}