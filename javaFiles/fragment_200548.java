lv.setOnItemClickListener(new OnItemClickListener() {    
       @Override
       public void onItemClick(AdapterView<?> arg0, View arg1,
                                int arg2, long arg3) {
              Intent i = new Intent(MainActivity.this, SecondActivity.class); 
              i.putExtra("myBeerObject", lv.getItemAtPosition(arg2));   
              startActivity(i); 
       } 
   });