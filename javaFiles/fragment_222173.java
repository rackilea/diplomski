public abstract class TrackedFragment extends Fragment{

    @Override
    public void onResume() {

        super.onResume();

        final Tracker tracker = yourApplicationInstance.getTracker();
        if(tracker != null){

            tracker.setScreenName(getClass().getSimpleName());
            tracker.send(new HitBuilders.ScreenViewBuilder().build());
        }
    }
}