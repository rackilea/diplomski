List<String> list = new ArrayList<>();
ArrayAdapter<String> adatper = new ArrayAdapter<String>(this, android.R.layout.layout, list);
listView.setAdapter(adapter);

list.add("Another item");
adapter.notifyDataSetChanged();