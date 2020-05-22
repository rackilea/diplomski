boolean handled = NavigationUI.onNavDestinationSelected(menuItem, navController);
if (!handled) {
    if(id == R.id.nav_logout){
        AlertDialog.Builder conDialog = new AlertDialog.Builder(BundyClock.this);
        conDialog.setTitle("Confirm");
        conDialog.setMessage("Are you sure you want to log out?");
        conDialog.setCancelable(false);

        conDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(BundyClock.this, MainActivity.class));
                Toast.makeText(getApplicationContext(),"Successfully Logout",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        conDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        final AlertDialog sdialog = conDialog.create();
        sdialog.show();
    }
}

DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
drawer.closeDrawer(GravityCompat.START);
return handled;