@Override
public boolean onCreateOptionsMenu(Menu menu) {
  MenuInflater inflater = getMenuInflater();
  inflater.inflate(R.menu.drawer_menu, menu);
  return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
  // Handle item selection
  switch (item.getItemId()) {
      case R.id.menu_go_home:
          String itemTitle = item.getTitle();
          Constant.CATEGORY_URL = SERVER_URL+"api.php? + itemTitle;
          return true; 
       default:
          return super.onOptionsItemSelected(item);
  }
}