spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
{
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // this line will get you the selected item of the spinner
        String selectedValue = parent.getItemAtPosition(position).toString(); 
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
});