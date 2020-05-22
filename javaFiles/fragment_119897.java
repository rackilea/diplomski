@Autowired
  private SystemStateWebSocketBuffer buffer;
  //...
  @Override
  public synchronized void afterConnectionEstablished(WebSocketSession session) 
                           throws Exception {
    this.session = session;
    buffer.add(this);
  }