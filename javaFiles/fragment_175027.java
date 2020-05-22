void invokeMessageListener(Object o) {
  if (o instance MyMessageListenerAware) {
    MyMessageListener l = ((MyMessageListenerAware) o).getMyMessageListener();
    l.onMessage(o);
  }
}