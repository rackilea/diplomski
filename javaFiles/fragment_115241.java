public void onClick(View clicked){
    if(clicked.getId() == R.id.Attack){
        Spinner spinner = (Spinner) findViewById(R.id.UseItem);

      //Sample String ArrayList
        ArrayList<String> arrayList1 = new ArrayList<String>();

        arrayList1.add("Bangalore");
        arrayList1.add("Delhi");
        arrayList1.add("Mumbai");
        ArrayAdapter<String> adp = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,arrayList1);
        spinner.setAdapter(adp);

        spinner.setVisibility(View.VISIBLE);
       //Set listener Called when the item is selected in spinner
       spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
       {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long arg3) 
            {
                String city = "The city is " + parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), city, Toast.LENGTH_LONG).show();

            }

            public void onNothingSelected(AdapterView<?> arg0) 
            {
                // TODO Auto-generated method stub
            }
        });

        //BattleRun.dismiss();
        Log.d("Item","Clicked");

    }
}