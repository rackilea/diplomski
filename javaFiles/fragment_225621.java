spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
            int position, long id) {
        String str1 = (String) parent.getItemAtPosition(position);
        if (spinner2.getAdapter() == null) {
               ArrayList<String> list =  new ArrayList( Arrays.asList(arrayMonths));
               list.remove("January");
               ArrayAdapter adapter = new ArrayAdapter<String>(ConnectedSpinnersStartEnd.this, android.R.layout.simple_spinner_item, list);
               spinner2.setAdapter(adapter);
        }