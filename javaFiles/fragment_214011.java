class ConnectionHandler implements Runnable{
        Socket connection;
        public ConnectionHandler(Socket connection){
             this.connection = connection;
        }

        public void run(){
           //here you do all the code associated with handling the connection
           //such as your Object Streams and so on.
        }
 }