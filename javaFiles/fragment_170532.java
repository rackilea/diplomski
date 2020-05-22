Socket s = new Socket(server, port);
InputStream in = s.getInputStream();
OutputStream out = s.getOutputStream();

consumer.setStream(in);     // Or vice-versa
producer.setStream(out);    // You can also provide it as a constructor argument