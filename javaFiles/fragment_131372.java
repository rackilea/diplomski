@Override
public void onBackPressed() {
    // Pressing back popped the back stack, nothing else to do
    FragmentManager fragmentManager = getSupportFragmentManager();

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
    } else if (!fragmentManager.isStateSaved() && fragmentManager.popBackStackImmediate()) {
        return;
    } else {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Home.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}