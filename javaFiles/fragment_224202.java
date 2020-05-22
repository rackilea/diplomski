@Override
public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.activity_main_drawer, menu);    

    return true;
}

@Override
public boolean onPrepareOptionsMenu(Menu menu) {

    menu.findItem(R.id.nav_spellbook).setVisible(magical);

    return true;
}