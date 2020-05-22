private ArrayList<People> peopleList = new ArrayList<People>();
peopleList.add(new People("name1", "phone1","address1");
peopleList.add(new People("name2", "phone2","address2");

// adaptor
PeopleListAdapter adaptor = new PeopleListAdapter(getApplicationContext(),peopleList);
//some list view
listView.setAdapter(adapter);