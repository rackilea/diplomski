public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case R.id.about:
   // startActivity(new Intent(this, About.class));
    return true;
    case R.id.help:
    startActivity(new Intent(this, Help.class));
    return true;
    case R.id.setting:
    Intent settingsActivity = new Intent(getBaseContext(),
                                                Preferences.class);
                                startActivity(settingsActivity);


        return true;
    default:
    return super.onOptionsItemSelected(item);
    }