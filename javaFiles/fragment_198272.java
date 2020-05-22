try
      {
        Socket s = serverSocket.accept();
        ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
        Object obj = oin.readObject();
        oin.close();
      }catch(Exception ex){}