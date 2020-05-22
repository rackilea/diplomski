BufferedImage img = ImageIO.read(new File("src/test.jpg"));
 ByteArrayOutputStream baos = new ByteArrayOutputStream();        
 ImageIO.write(img, "jpg", baos);
 baos.flush();
 byte[] buffer = baos.toByteArray();

 DatagramSocket clientSocket = new DatagramSocket();       
 InetAddress IPAddress = InetAddress.getByName("192.168.43.1");
 System.out.println(buffer.length);

  DatagramPacket packet = new DatagramPacket(buffer, buffer.length, IPAddress, 9876);

  clientSocket.send(packet);