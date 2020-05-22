EditText textField =(EditText)findViewById(R.id.item_edittext);
        Spinner spineer;
        spinner= (Spinner)findViewById(R.id.spinner_item);
        spineer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l{ 
        String selectedItemInSpinner=spinner.getSelectedItem().toString(); 
        textField.setText(selectedItemInSpinner);
        }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
        });