@Override
public boolean onOptionsItemSelected(MenuItem item) {
     if (item.getId() == android.R.id.home) {
          // do what you want here
          return true; // prevent the drawer to draw again;
     }
     return super.onOptionsItemSelected(item);
}