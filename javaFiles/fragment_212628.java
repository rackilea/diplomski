@Override
public void onPause() {
    super.onPause();
    mGoogleClient.stopAutoManage(getActivity());
    mGoogleClient.disconnect();
}