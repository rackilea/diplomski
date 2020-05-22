// Reference the spinner    
    Spinner spinner = (Spinner) findViewById(R.id.spinner);

    // Set spinner onItemClickListener
    spinner.setOnItemSelectedListener(new OnItemSelectedListener() { 

            @Override 
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {

                Toast.makeText(secActivity.this, "You have clicked", Toast.LENGTH_SHORT).show();
            } 
        });