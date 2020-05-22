@Override
public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.option_menu, menu); 

    MenuItem item = menu.findItem(R.id.state);
    item.setTitle(MyMenuTitle);

    return super.onCreateOptionsMenu(menu);
}