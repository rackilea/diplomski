AdapterView.OnItemSelectedListener

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, 
    long id) {
    Toast.makeText(getApplicationContext(), animalList[position], 
    Toast.LENGTH_LONG).show();
     }