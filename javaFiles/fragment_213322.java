List<de.magnum_gmbh.mw.MenuItem> menuItems = new ArrayList<>();
        //create your elements of navigation drawer
        de.magnum_gmbh.mw.MenuItem menuItem = new de.magnum_gmbh.mw.MenuItem();
String[] titles = {"Addresses", "Articles", "Invoices","Orders","Settings"};
        Integer[] images = {R.drawable.contacts,R.drawable.articles,R.drawable.invoices,R.drawable.orders,R.drawable.settings};
        for(int i=0;i<5;i++) {
            menuItem.setImageId(images[i]);
            menuItem.setTitle(title[i]);
            menuItems.add(menuItem);
            }
        //initialize your own adapter 
        mDrawerList.setAdapter(new MyAdapter(this, R.layout.drawer_list_item, menuItems));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());