/**
  * Constructs a server.
  * @param port Port to listen to.
  * @param protocol Protocol of messages.
  * @throws IOException when something goes wrong.
  */
 public ChannelMessageServer(int port) throws IOException {
  this.server = ServerSocketChannel.open();
  this.server.configureBlocking(false);
  this.server.socket().bind(new InetSocketAddress(port));
  this.server.register(this.selector, SelectionKey.OP_ACCEPT);
 }

 /**
  * Waits for event, then exits.
  * @throws IOException when something goes wrong.
  */
 protected void listen() throws IOException {
  // see if there are any new things going on
  this.selector.select();
  // process events
  Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
  while(iter.hasNext()) {
   SelectionKey key = iter.next();
   // do something with the connected socket
   iter.remove();
   if(key.isValid()) this.process(key);
  }
 }

 /**
  * Processes a selection key.
  * @param key SelectionKey.
  * @throws IOException when something is wrong.
  */
 protected void process(SelectionKey key) throws IOException {
  // if incoming connection
  if(key.isAcceptable()) {
   // get client
   SocketChannel client = (((ServerSocketChannel)key.channel()).accept());
    try {
     client.configureBlocking(false);
     client.register(this.selector, SelectionKey.OP_READ);
    }
    catch(Exception e) {
     // catch
    }
  }
  // if readable, tell messenger to read
  else if(key.isReadable()) {
  // read
  }
 }