@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case MENU_HELP:
        startActivity(new Intent(MyClass.this,Help.class));
          break; }