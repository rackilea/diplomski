ArrayList<ListParser> arrayOfListParsers = new ArrayList<ListParser>();
AccountAdapter adapter = new AccountAdapter(this, arrayOfListParsers);
ListView listView = (ListView) findViewById(R.id.list_view);
listView.setAdapter(adapter);

ListParser newUser = new ListParser(String.valueOf(listFromDB.get(0).getaccountName()), String.valueOf(listFromDB.get(0).getDescription()), String.valueOf(listFromDB.get(0).getBalance()));
adapter.add(newUser);