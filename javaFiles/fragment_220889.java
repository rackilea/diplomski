@Override
public boolean onCreateOptionsMenu(Menu menu){
    MenuInflater Inflater = getMenuInflater();
    Inflater.inflate(R.menu.main_menu, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){          
        case R.id.MenuClass:
            startActivity (new Intent ("com.clayton.calendar.TOCLASS"));
            return true;

        case R.id.MenuFriends:
            startActivity (new Intent ("com.clayton.calendar.TOFRIENDS"));
            return true;

        default:
            return super.onOptionsItemSelected(item);
    }   
}