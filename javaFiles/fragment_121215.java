NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);// initialization of navigation menu
    navigationView.setNavigationItemSelectedListener(this);//adding listener to navigation menu

    List<String> item = db.getAllMenu();//getting data from database

    ListView lv=(ListView)findViewById(R.id.list_view_inside_nav);//initialization of listview

    String[] lv_arr = new String[item.size()];//creating a String[] just as the size of the data retrieved from database

    //adding all data from item list to lv_arr[]
    for(int i=0;i<item.size();i++){
        lv_arr[i]= String.valueOf(item.get(i));
    }

    //setting adapter to listview
    lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,
           android.R.layout.simple_list_item_1, lv_arr));