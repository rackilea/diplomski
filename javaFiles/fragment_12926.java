ArrayList<String> family = new ArrayList<String>();
    family.add("Abc");
    family.add("Def");
    family.add("Ghi");

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, 
    android.R.layout.simple_list_item_1,family );
    MyList.setAdapter(arrayAdapter);