//Class variable...
OnFragmentInteractionListener mCallback;

@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        mCallback = (OnFragmentInteractionListener) activity;
            } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }