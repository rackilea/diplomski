//send UDP packet
                        DatagramSocket UDP_packet = new DatagramSocket(SERVERPORT);
                        UDP_packet.setBroadcast(true);
                        byte[] b = "83hcX1".getBytes("UTF-8");
                        DatagramPacket outgoing = new DatagramPacket(b, b.length, getBroadcastAddress(Main.this), SERVERPORT);                  
                        UDP_packet.send(outgoing);
                        //receive UDP packet
                        boolean gogo = false;
                        while (!gogo) {                     
                            byte[] buffer = new byte[1024];
                            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);    
                            UDP_packet.receive(incoming);
                            String message = new String(incoming.getData(), 0, incoming.getLength(), "UTF-8");
                             if (message.equals("94dbF5")) {
                                 gogo = true;
                                 SERVER_IP = incoming.getAddress();
                             }                  
                        }               
                        UDP_packet.close();