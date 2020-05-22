ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1 );
listView.setAdapter(adapter);

for (String s : entry) {
    adapter.add(s);
}