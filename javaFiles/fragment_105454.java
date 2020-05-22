private Socket socket = null;
        private Socket remoteSocket = null;
        private HTTPReqHeader request = null;
        ClientHandler(Socket socket)
        {
           this.socket = socket;
           request = new HTTPReqHeader();
           request.parse(socket); // I read and parse the HTTP request here
        }

       public void run()
       {

            remoteSocket = new Socket(request.url,request.port);

            if(request.isSecure() )
            {
                 // send ok message to client
                 String ConnectResponse = "HTTP/1.0 200 Connection established\n" +
                                          "Proxy-agent: ProxyServer/1.0\n" +
                                          "\r\n";
                try
                {
           DataOutputStream out =  new DataOutputStream(socket.getOutputStream());
                   out.writeByte(ConnectResponse);
                    out.flush();
                } catch(Exception e) {} 

            }

            // start connecting remoteSocket and clientSocket 
            ...........
       }