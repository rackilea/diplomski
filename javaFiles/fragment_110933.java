// I assume, the String is comma separated, which indicates the array.
List<String> arrayList = Arrays.asList(array.split("\\s*,\\s*"));

ListView lv = (ListView) findViewById(R.id.extView);
ListAdapter customAdapter = new ListAdapter(this, R.layout.list_item, arrayList);
lv.setAdapter(customAdapter);