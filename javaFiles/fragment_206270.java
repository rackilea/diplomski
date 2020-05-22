List<String> data = new ArrayList<>();

// sample data
data.add("Data 1");
data.add("Data 2");

final ArrayAdapter<String> adapter = new ArrayAdapter<>(this /*context*/,
        android.R.layout.simple_list_item_1, android.R.id.text1, data);

ListView listView = findViewById(R.id.listView);
listView.setAdapter(adapter);