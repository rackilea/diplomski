String[] arr = new String[]{"One", "Two", "Three", "Four", "Five"};
List<String> data = new ArrayList<String>();
for (String item : arr) {
     data.add(item);
}
ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_item_medication, data);
mListViewItem.setAdapter(adapter);