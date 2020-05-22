private class SocketServerListenToMessage implements Runnable {
        protected Socket clientSocket = null;

        public SocketServerListenToMessage(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                while (true){
                    InputStream is = clientSocket.getInputStream();
                    byte[] lenBytes = new byte[4];
                    is.read(lenBytes, 0, 4);
                    int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                            ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                    byte[] receivedBytes = new byte[len];
                    is.read(receivedBytes, 0, len);
                    final String received = new String(receivedBytes, 0, len);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Client Says: " + received, Toast.LENGTH_LONG).show();
                            Log.w("Client Says", received);

                        }
                    });
                }

            } catch (IOException e) {
                Log.e("IO ERR FROM LISTEN MSG", e.toString());
            } catch (Exception e) {
                Log.e("EX ERR FROM LISTEN MSG", e.toString());
            } finally {
                try{
                    clientSocket.close();
                    Log.w("CLIENT DISCONNECTED", "A client is disconnected.");
                }catch (IOException e){
                    Log.w("IO ERR DISCONNECTION", e.toString());
                }
            }
        }
    }