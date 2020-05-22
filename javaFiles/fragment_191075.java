areaspinner = (Spinner) findViewById(R.id.areaspinner);
    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, array);  //array you are populating  
    adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
    areaspinner.setAdapter(adapter2);
        areaspinner.setSelection(Integer.parseInt(strarea));