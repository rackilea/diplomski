try {
            socket = new Socket("192.168.1.74", 23);
            dataOutputStream.Object BUFFER = null;
            write(BUFFER);
            String buffer="PWON\r";
            OutputStream os=socket.getOutputStream();
            os.write(buffer.getBytes()); 
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }