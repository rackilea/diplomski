if (match != null) {
    ArrayList<String> namesList = new ArrayList<>();
    resultTxt.setText( matcheddata );
    namesList.clear();
    namesList.add(matcheddata);
    namesList.add(matcheddata);
    ArrayAdapter<String> adapter = new ArrayAdapter<>( getApplicationContext(), android.R.layout.simple_selectable_list_item, namesList );
    listView.setAdapter(adapter);
}