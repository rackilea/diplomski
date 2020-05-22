// Locate spinner1 in activity_main.xml
Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

// Locate mySpinner in activity_main.xml
Spinner mySpinner = (Spinner) findViewById(R.id.my_spinner);

// Spinner adapter
List<String> typesofjobsunique = new ArrayList<>(new LinkedHashSet<>(typesofjobs)); 
spinner1.setAdapter(new ArrayAdapter<String>(MainActivity.this,
        android.R.layout.simple_spinner_dropdown_item, typesofjobsunique));

spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // **EDIT**
        List<String> myWorldList = getWorldListForItem(parent.getItemAtPosition(pos));
        Collections.sort(myWorldList);
        mySpinner
                .setAdapter(new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        myWorldList));

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
});

Collections.sort(typesofjobsunique);