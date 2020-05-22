ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,yourArray);

ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, yourArray);

arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

spinner1.setAdapter(arrayAdapter);

arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

spinner2.setAdapter(arrayAdapter2);

spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        //remove the selected item from other adapter
        arrayAdapter2.remove(arrayAdapter.getItem(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});