MessageProducer producer = session.createProducer(queue);
for(int i=0; i<10000; i++) {
    String payload = "Important Task"+i;
    Message msg = session.createTextMessage(payload);

   System.out.println("Sending text '" + payload + "'");

   producer.send(msg);
}