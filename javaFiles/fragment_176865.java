public void addItemsOnSpinner() {

    List<String> list = new ArrayList<String>();
    for (int i=0; i<=60; i++){
        String num = String.valueOf(i);
        list.add(num);
    }
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, list);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinner1 = (Spinner) findViewById(R.id.modesrangespinner1);
    spinner2 = (Spinner) findViewById(R.id.modesrangespinner2);
    spinner3 = (Spinner) findViewById(R.id.modesrangespinner3);
    spinner4 = (Spinner) findViewById(R.id.modesrangespinner4);
    spinner5 = (Spinner) findViewById(R.id.modesrangespinner5);

    spinner1.setAdapter(dataAdapter);
    spinner2.setAdapter(dataAdapter);
    spinner3.setAdapter(dataAdapter);
    spinner4.setAdapter(dataAdapter);
    spinner5.setAdapter(dataAdapter);
}