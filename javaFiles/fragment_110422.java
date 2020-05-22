// move initialization of references before loop
Spinner mySpinner = (Spinner) findViewById(R.id.spincourse);
List<String> itemList =  new ArrayList<>();

for (Iterator i = courseusers.iterator(); i.hasNext();) {
    Properties p = (Properties) i.next();
    // add items to list
    itemList.add(p.getCourseId()+" "+p.getRoom()+" "+p.getSection());     
}
// data list is ready so setup adapter and display spinner
ArrayAdapter<String> adapter;
  adapter = new ArrayAdapter(this, 
         android.R.layout.simple_spinner_item,
         itemList);

adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

mySpinner.setAdapter(adapter);