private void setMenus() {
    int temp = 0;
  //Mine was inside of a fragment, hints the getActivity() call
    NavigationView navView22 = getActivity().findViewById(R.id.navigation_view);
    MenuItem oneItem = navView22.getMenu().findItem(0);
        if (oneItem == null){
        Menu m = navView22.getMenu();
        SubMenu sm0 = m.addSubMenu(
                getResources().getString(R.string.clickToSelectRookies));
        sm0.add(0,
                temp, temp, getResources().getString(R.string.signAllString));
            tempRooks.add(round1.get(0));
  /*I had to create the entire menu dynamically, so I did so by creating 
  subMenus in my menus in numerical order
  I then created an arraylist to hold all my objects in that same order
  though in retrospect I should have just used a HashMap!!
  finally in the onClick I was able to listen for which subMenu item was clicked
   and since the menu's and my arraylist of objects corresponded I then pulled 
  the correct object from my arraylist. I realize this is a little hacky, but 
  hopefully if you do not find the answer you can do this temporarily.
  If you do find a better solution please post so we all can learn. Thank YOU!!