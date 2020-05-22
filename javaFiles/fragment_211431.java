public class MyActivity implements MyActivityInterface {

    private MyFragment myFragment;

    @Override
    public void passInformationToActivity(Object obj) {
        Log.e(TAG, "Information was passed to the activity");
    }

    public void sendInformationToFragment(Object obj) {
        myFragment.sendInformation(obj);
    }
}