Selector selector = Selector.open();
  for(int port=3000;port<3010;port++){
     ServerSocketChannel server = ServerSocketChannel.open();
     server.configureBlocking(false);
     server.socket().bind(new InetSocketAddress(port));
     server.register(selector, SelectionKey.OP_ACCEPT);
     System.out.println("Bound to " + server);
  }

  ByteBuffer buffer = ByteBuffer.allocate(0x4000);
  while(selector.isOpen()){
     selector.select();
     Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
     while(keys.hasNext()){
        SelectionKey key = keys.next();
        if(!key.isValid()) continue;

        if(key.isReadable()){
           buffer.clear();
           SocketChannel socket = (SocketChannel)key.channel();
           if(socket.read(buffer) == -1){ //-1 is end of stream
              System.out.println("Client Disconnected " + socket);
              socket.close();
              continue;
           }else{
              buffer.flip();
              socket.write(buffer); //echo data back to client
           }

        }else if(key.isAcceptable()){
           ServerSocketChannel serverChannel = (ServerSocketChannel)key.channel();
           SocketChannel socket = serverChannel.accept();
           socket.configureBlocking(false);
           socket.register(selector, SelectionKey.OP_READ);
           System.out.println("Client Connected " + socket);
        }
     }
     selector.selectedKeys().clear();
  }