final Categories categories = null;
    final List<Categories> AllCategories ;
    AllCategories =  (List<Categories>) getAll(categories);

    final ArrayList<String> list = new ArrayList<String>();
    for (int i=0;i<AllCategories.size();i++) {
        String val=AllCategories.get(i).getName().toString();
        list.add(new String(val));
    }
    final ArrayAdapter arrayAdapter;
    arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,list);
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dropdown.setAdapter(arrayAdapter);

    dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            String category = adapterView.getItemAtPosition(i).toString();
            String name = new String(category);
            Categories cat = new Categories();
            cat.setName(name);
            Categories cat1 = getCategoryByName(new String(cat.getName()));



            Toast.makeText(getActivity(),"Selected Category : " + category, Toast.LENGTH_LONG).show();


            List<Item> listOfItems = getAllItemsInCategoryById(cat1);


            final ArrayList<String> listItemString = new ArrayList<String>();

            for(int j=0;j<listOfItems.size();j++){

                String val = listOfItems.get(j).getName().toString();

                System.out.println(val);

                listItemString.add(new String(val));

            }

            final ArrayAdapter arrayAdapter1;
            arrayAdapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,listItemString);
            arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dropdown2.setAdapter(arrayAdapter1);


        }



        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });