spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
{
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        switch(selectedItem) {
            case "UK":
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case "USA":
                // do something
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }           
});