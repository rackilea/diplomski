String stat = "Arif||44444~Balin||33333~Cavin||55555~Den||66666~";
    String[] parts = stat.split("~");
    List<String> names = new ArrayList<>();
    List<String> numbers = new ArrayList<>();

    for(int i = 0; i < parts.length; i++) {         
        int found = parts[i].indexOf("||");
        names.add(parts[i].substring(0,found));         

        numbers.add(parts[i].substring(found+2,parts[i].length()));

    }


 spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()   {
   @Override
   public void onItemSelected(AdapterView<?> parent, View view, int posion, long id) {

     //here you can get the position (local argument position) of corresponding numbers to the names         

      String name = names.get(position); 
      String number = number.get(position);
   }
  @Override public void onNothingSelected(AdapterView<?> arg0) { 
    // TODO Auto-generated method stub
  } 
});