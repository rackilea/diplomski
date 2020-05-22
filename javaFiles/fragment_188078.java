UNEdifactInterchange41 edi = new UNEdifactInterchange41();
UNB41 header = new UNB41();
header.setSender(null);
Party sender = new Party();
sender.setInternalId("TEST");
header.setSender(sender);
edi.setInterchangeHeader(header);

D98AInterchangeFactory factory = D98AInterchangeFactory.getInstance();

StringWriter ediOutStream1 = new StringWriter();
factory.toUNEdifact(edi, ediOutStream1);