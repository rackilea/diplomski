public class LandingFragment extends BaseFragment {

    private LandingFragmentCallbacks mListener;

    ...

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (LandingFragmentCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement LandingFragmentCallbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * LandingFragmentCallbacks is an interface that all the activities that use {@link
     * me.upclose.aether.ui.fragments.LandingFragment} has to implement.         
     */
    public static interface LandingFragmentCallbacks {

        public void onRequestShowLoginFragment();

        public void onSkipLogin();
    }  
}