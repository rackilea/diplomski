import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActivityBarActivity {

      ActionBar mActionBar = getSupportActionBar();
      mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
  }