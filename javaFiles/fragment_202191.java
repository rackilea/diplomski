MenuItem logoutItem = menu.findItem(R.id.logout_btn);
//... initialize other menu items here

//use hidden state to define when to hide item(s)
if(isHideMenuState){
   logoutItem.setVisible(false);
  //by now the ellipses(...) should go off
  //if not try using setShowAsAction passing (SHOW_AS_ACTION_NEVER)
 }
else{ 
   logoutItem.setVisible(true);
 }