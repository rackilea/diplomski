@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate( R.menu.main_menu, menu );

    // hide menu item
    menu.findItem( R.id.menu_item_1 ).setVisible( false );
    return true;
}