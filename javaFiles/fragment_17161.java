ArrayAdapter<String> adapter_state1 = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, colors1);
adapter_state1
        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner1.setAdapter(adapter_state1);
spinner1.setSelection(0);
selstate1 = (String) spinner1.getSelectedItem();

 ArrayAdapter<String> adapter_state2 = new ArrayAdapter<String>(this,
         android.R.layout.simple_spinner_item, colors1);
 adapter_state2
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner2.setAdapter(adapter_state2);
spinner2.setSelection(0);
selstate2 = (String) spinner2.getSelectedItem();

spinner1.setOnItemSelectedListener(this);
spinner2.setOnItemSelectedListener(this);
spinner3.setOnItemSelectedListener(this);
spinner4.setOnItemSelectedListener(this);