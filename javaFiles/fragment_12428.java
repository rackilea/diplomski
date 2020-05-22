Spinner spinner = (Spinner) layout.findViewById(R.id.myspinner1);
spinner.setAdapter(new FoodAdapter(this, android.R.layout.simple_spinner_item, list);
spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
      Food food = (Food) parent.getItemAtPosition(pos);
      //Do whatever you need to do with selected value.  You have reference to both the food and the calories.
    }
    public void onNothingSelected(    AdapterView<?> parent){

    }
  }