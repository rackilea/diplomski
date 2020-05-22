TestPojo testPojo = new TestPojo();
Outbound outbound = new Outbound();

outbound.setAddress(new String[]{"t91", "t0992"});
outbound.setOutMessage(new OutMessage("Hello World"));
outbound.setReceipt(new Receipt("http://example.com/Delivery", "some-to-the-request"));
outbound.setSenderName("Inc.");
outbound.setSend("t678");
testPojo.setOutbound(outbound);

System.out.println(new Gson().toJson(testPojo));