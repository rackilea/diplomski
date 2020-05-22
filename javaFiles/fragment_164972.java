public class MainActivity {

   @Override
   public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN) // Seems like you're updating UI, so use the main thread
    public void onDataReady(DataReadyEvent event) {
       /* Do whatever it is you need to do - remember you can add properties to your event and pull them off here if you need to*/
    };
}