public class MyActivity implement MyEventListener {

    public void startEvent() {
        new MyAsyncTask(this).execute();
    }           

    @Override
    public void onEventCompleted() {
        // TODO
    }

    @Override
    public void onEventFailed() {
        // TODO
    }
}