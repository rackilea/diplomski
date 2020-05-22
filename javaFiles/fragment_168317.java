Bridge bridge = Bridge.getInstance();

Message message = new Message();

message.setData("Hello from Merapi Java.");

bridge.sendMessage(message);