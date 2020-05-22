public void onCreate(Bundle bundle) {

    ...

    List<String> strings = new ArrayList<>();
    strings.add("John Doe");
    strings.add("Jane Doe");
    strings.add("Bill Gates");
    strings.add("Mark Zuckerberg");

    ListView listView = (ListView) findViewById(R.id.list);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_gallery_item, strings);
    listView.setAdapter(adapter);

    ...
}