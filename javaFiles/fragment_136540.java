try {
            sock = new DatagramSocket(portNumber);
            sock.setSoTimeout(250);
            while(keepListening) {
                try {
                    pack = new DatagramPacket(recievedData, BUFFERSIZE);
                    sock.receive(pack);

                    String data = new String(pack.getData(), 0, pack.getLength());
                    addToLog(data);
                    System.out.println(data);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SocketException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            sock.close();
        }