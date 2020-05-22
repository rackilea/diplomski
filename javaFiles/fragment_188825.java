ObjectMapper mapper = ... ; // Get hold of a Jackson ObjectMapper
session.createTextMessage(mapper.writeValueAsString(myPojo));

// and on the receiving side
TextMessage message = ....; // From the message receiver
MyPojo myPojo = mapper.readValue(message.getText(), MyPojo.class);