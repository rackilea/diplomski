@Override
public boolean onPrepareOptionsMenu (Menu menu) {

    menu.clear();

    if (OPTIONS_TYPE == 0) {
        OPTIONS_TYPE = 1; 
        getMenuInflater().inflate(R.menu.secondmenu, menu);

    }
    else { // Photo + delete option {
        OPTIONS_TYPE = 0;
        getMenuInflater().inflate(R.menu.firstmenu, menu);
    }

    return super.onPrepareOptionsMenu(menu);
}