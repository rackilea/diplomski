public SomeAction getAction() {
    final SomeSubscriber me = this;
    class Action implements SomeAction {

        @Override
        public void doAction() {
           me.doSomething();
        }
    }

    return new Action();
}