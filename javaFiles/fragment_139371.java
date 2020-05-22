class MyEventListeningClass {
   @Subscribe public void onEvent(MyEvent e) {
      // react to event
   }
}
...
eventBus.register(new MyEventListeningClass());