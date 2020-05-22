btnAction.setOnClickListener(new View.OnClickListener() {
    @override
    public void onClick(View v) {
        new Thread("thread_udp"){
            public void run(){
                try {
                    String messageStr = "test!";
                    int server_port = 1111;
                    DatagramSocket s = new DatagramSocket();
                    InetAddress local = InetAddress.getByName("My.Public.Server.IP");
                    int msg_length = messageStr.length();
                    byte[] message = messageStr.getBytes();
                    DatagramPacket p = new DatagramPacket(message, msg_length, local,server_port);
                    s.send(p);
                } catch (Exception e) {
                    e.printStackTrace()
                }
            }
        }.start()

    }
}