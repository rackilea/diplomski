public class MainActivity extends Activity {
    ...
    // Create SharedPreferences and Editor
    SharedPreferences sharedPref;
    SharedPreferences.Editor;
    ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        sharedPref= getSharedPreferences("myPref", Context.MODE_PRIVATE);
        loginStateEditor=sharedPref.edit();

        if (sharedPref.getBoolean("success_login", false)) {
            // Start Your LandingActivity
            Intent i = new Intent(MainActivity.this, LandingActivity.class);
            startActivity(i);
        }

        ...

        @Override
        public void onSuccess(LoginResult loginResult) {
            Intent i = new Intent(MainActivity.this, LandingActivity.class);
            // Save login state on shared pref.
            loginStateEditor.putBoolean("success_login", true);
            loginStateEditor.commit();
            ...
        }
    ...
}