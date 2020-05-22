ftp = new FTPSClient() 
      {
        private Socket socket;

        protected Socket _openDataConnection_(int command, String arg) throws IOException
        {
          if (socket != null && socket instanceof SSLSocket)
          {
            // We have problems resuming cached SSL Sessions. Exceptions are
            // thrown and the system crashes... So we invalidate each SSL
            // session we used last.
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.getSession().invalidate();
          }
          socket = super._openDataConnection_(command, arg);
          return socket;
        }
      };