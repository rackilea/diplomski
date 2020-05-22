Spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub

        String selectedValue = arg0.getSelectedItem().toString();
        if(selectedValue.equalsIgnoreCase(Red_Line))
        {
            ArrayAdapter<String> firstAdapter = new ArrayAdapter<String (StationList.this,R.array.Red_Line);
            Spinner2.setAdapter(firstAdapter);//
        }

        if(selectedValue.equalsIgnoreCase(Blue_Line))
        {
            ArrayAdapter<String> firstAdapter = new ArrayAdapter<String (StationList.this,R.array.Blue_Line);

            Spinner2.setAdapter(firstAdapter);
        }
    }
});