interface MyMessageListenerAware {
  MyMessageListener getMyMessageListener();
}

// and this is the original MyMessageListener
interface MyMessageListener {
  void onMessage(Object o);
}