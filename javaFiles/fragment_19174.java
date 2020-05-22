private static class CertainListenerImpl implements CertainListener {

    private final MyFragment this$0; // rename to taste

    CertainListenerImpl(MyFragment myFragment) {
        this$0 = myFragment;
    }

    @Override
    private void onCertainEventsOccurrence() {
         this$0.doSomething();
    }


}