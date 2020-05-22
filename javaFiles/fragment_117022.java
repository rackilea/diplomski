//set spinner1 for user input of available thickness
    spinner1 = (Spinner) findViewById(R.id.thickness);
    String[] items = new String[]{"Thickness", "1.2", "1.5", "2", "2.5", "3", "4"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
    spinner1.setAdapter(adapter);

    //set spinner2 for user input of available width
    spinner2 = (Spinner) findViewById(R.id.width);
    items = new String[]{"Width", "1219", "1500", "1524"};
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
    spinner2.setAdapter(adapter);