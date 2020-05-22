public class Test extends Activity {
    public Test(Context context) {
        try {
            String hello = context.getResources().getString(R.string.app_name)

        } catch (Exception e) {
            Log.d("myLogs", e.getMessage());
        }
      }
}