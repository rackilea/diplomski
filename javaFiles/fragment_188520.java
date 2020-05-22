sectionsSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
{
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
       sectionSelected();     
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // Do nothing       
    }

});