final Client[] clients = new Client[30];
for (int i = 0; i < 30; i++) {
    final Integer integer = new Integer(i);
    final Client client = new Client("localhost", SERVPORT);
    clients[i] = client;
    new Thread(){
        public void run(){
            client.send(integer.toString());
        }
    }.start();
}