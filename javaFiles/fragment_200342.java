public static Boolean running = false;

class LoginActivity extends Activity {

  @Override
  public void onStart() {
     super.onStart();
     Fragment.running = true;
  }
}