public void printFile(File file, String printerIp) throws PrintException, IOException {

            Socket socket = new Socket(printerIp, 9100);

            FileInputStream fileInputStream = new FileInputStream(file);
            byte [] mybytearray  = new byte [(int)file.length()];

            fileInputStream.read(mybytearray,0,mybytearray.length);

            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(mybytearray,0,mybytearray.length);

                 //Curious thing is that we have to wait some time to make more prints.
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }

            outputStream.flush();
            outputStream.close();
            socket.close();
            fileInputStream.close();
        }