if (match != null) {
    ArrayList<String> namesList = new ArrayList<>();
    resultTxt.setText( matcheddata );
    // namesList.clear(); // You don't need to clear it as you just created it above
    namesList.add(matcheddata);
    ArrayAdapter<String> adapter = new ArrayAdapter<>( getApplicationContext(), android.R.layout.simple_selectable_list_item, namesList );
    listView.setAdapter(adapter);
}