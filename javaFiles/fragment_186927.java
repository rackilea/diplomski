public class BaseActivity extends AppCompatActivity {

    // Any other common methods

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
               Intent opensettings = new Intent(this, SettingsActivity.class);
               startActivity(opensettings);
                return true;
            case R.id.help:
              ...others

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}