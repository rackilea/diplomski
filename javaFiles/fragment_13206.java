@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return true;
}


@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.action_logout:
            //Logout
            return true;
        case R.id.action_redirAdmin:
            //Goto AdminConsole
            //startActivity(new Intent(MainActivity.this, AdminConsole.class));
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}