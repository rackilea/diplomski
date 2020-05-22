public class MyFragment extends Fragment {

    private MyActivityInterface mInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mInterface = (MyActivityInterface) activity;
        catch (ClassCastException e) {
            Log.e(TAG, "Calling activity must implement MyActivityInterface");
            throw e;
        }
    }

    @Override
    public void onDetatch() {
        super.onDetatch();
        mInterface = null;
    }

    private void notifyActivityOfObject(Object obj) {
        mInterface.passInformationToActivity(obj);
    }

    public void sendInformation(Object obj) {
        Log.e(TAG, "Object received by Fragment");
    }
}