@Override
public boolean onMenuItemActionCollapse(MenuItem item) {
    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
    show_all_drugs();
    return true;
}