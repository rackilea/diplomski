String[] finalArray = new String[gameData.size()];
finalArray = gameData.toArray(finalArray);

// finalArray contains the selection for the spinner
final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, finalArray);

// Set the adapter here
listView.setAdapter(arrayAdapter);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO: Change the elements of finalArray here
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});