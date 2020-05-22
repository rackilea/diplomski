private class MyConnectionThread extends Thread {
        /** determines whether the thread is runnuing or not. */
        private boolean alive = false;
        private HttpConnection hconn = null; // or whatever connection method you want to use ( SocketConnection etc.)
        private InputStream inputStream = null; // or DataInputStream etc...

        public MyConnectionThread() {
            alive = false;
            // ...
            // ...
        }

        public void run() {
            alive = true;
            try {
                String connection_parameter = ";deviceside=false"; // [For BlackBerry: ] this parameter is for connection using MDS, need to add different parameters for different connection methods.
                hconn = (HttpConnection) Connector.open("http://your_url.com"+connection_parameter);
                int response = hconn.getResponseCode();
                if (response == HttpConnection.HTTP_OK) {
                    inputStream = hconn.openInputStream();

                    // process the result here by reading the inputStream ...
                    // ...
                    // ...
                }

                inputStream.close();
                hconn.close();

            }catch(Exception excp) {
                // Handle Exceptions here...
            }catch (Throwable e) {
               // Exception in reading inputStream
            }finally{
                alive = false;
                this.interrupt();
            }
        }

        /**
         * Forces the connection to close anytime.
         */
        public void closeConnection() {
            alive = false;
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                inputStream = null;
                if (hconn != null) {
                    hconn.close();
                }
                hconn = null;
                this.interrupt();
            } catch (Exception excp) {
                // Handle Exception here...
                System.out.println("Exception in closing HttpConnection: " + excp.toString());
            }
        }
    }