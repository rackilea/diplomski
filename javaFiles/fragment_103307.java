public abstract class AbstractActivity extends AppCompatActivity {

@Override
public boolean onNavigationItemSelected(MenuItem item) {
    super.onNavigationItemSelected(item);
    switch (item.getItemId()) {

        case R.id.nav_one:
            // Do something 
            break;

        case R.id.nav_two:
            // Do something
            break;

        case R.id.nav_three:
            // Do something
            break;

        default:
            break;

        }
    }
}