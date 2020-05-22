Messenger mng = Proton.messenger();
mng.start();
mng.subscribe("amqp://~xxx.xxx.xxx.xxx");

Message msg = Proton.message();
msg.setAddress("amqp://yyy.yyy.yyy.yyy");
....