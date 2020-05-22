public void ConvertSend() {
Map map = new HashMap();
map.put("Name", "Vimal");
map.put("Age", new Integer(45));
jmsTemplate.convertAndSend("jmsQueue", map, new MessagePostProcessor() {
    public Message postProcessMessage(Message message) throws JMSException {
        message.setIntProperty("ID", 9999);
        message.setJMSCorrelationID("123-99999");
        return message;
       }
   });
}