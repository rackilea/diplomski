@Override
public boolean onCreateOptionsMenu(MenuInflater inflater, Menu menu){
  boolean onlyFragments = !mDrawerLayout.isOpened(GravityCompat.START);
  Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.content_layout);
  visibleFragment.setHasOptionsMenu(onlyFragments);
  if(onlyFragments){
    return super.onCreateOptionsMenu(inflater,menu);
  }else{
     //here only activity inflates menu
     inflater.inflate(R.menu.activity_menu, menu);
     return true;
  }
}