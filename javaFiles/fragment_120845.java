spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() 
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
            {
             String selected_item = parent.getItemAtPosition(pos).toString();
             Log.d("TAG", "_log : item_selected : " + selected_item);
            }

            public void onNothingSelected(AdapterView<?> parent) 
            {

            }
        });