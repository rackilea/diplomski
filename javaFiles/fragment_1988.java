for (int i = 0; i < SomeValueHere; i++) { //you should try reading this value from your config if can , perhaps
     Fragment table = listOfFragment.get(i);

     Bundle tableInfo = new Bundle();//add a bundle to the fragment with some extra details
     tableInfo.putInt("room_config", SomeIndicatorHereToShowWhichConfigIsChosen);
     tableInfo.putInt("table_id", i);

     table.setArguments(tableInfo);
        yourAdapter.add(table);
    }