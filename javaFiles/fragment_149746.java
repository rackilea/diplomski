@Override
public void onAttach(Activity activity) {
    // Call to the Super Class
    super.onAttach(activity);

    // Attempt to Add the Interface
    try {

        m_callBack = (TalkToActivity) activity;

    } catch (ClassCastException e) {

        // Print to LogCat if the Parent Did not implement the interface
        Log.e(FRAGMENT_TAG, "Failed to implement interface in parent.", e);
    }
}