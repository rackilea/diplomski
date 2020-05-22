public class YourFragment extends Fragment {

    private Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onResume() {
        super.onResume();
        // BIND sensor here with mActivity, 
        // could also be done in other fragment lifecycle events, 
        // depends on how you handle configChanges

    }

    @Override
    public void onPause() {
        super.onPause();
        // UNBIND sensor here from mActivity, 
        // could also be done in other fragment lifecycle events, 
        // depends on how you handle configChanges
    }

}