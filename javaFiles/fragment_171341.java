boolean check;

       btnAddData.setOnClickListener(new View.OnClickListener() {
           @Override
             public void onClick(View v) {
                check =  myDb.checkDuplicate(locationText.getText().toString());
                if(check == true)
                {
                   myDb.insertData(locationText.getText().toString());
                   Toast.makeText(MainActivity.this,"already reported",Toast.LENGTH_LONG).show();
                } else{
                 Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show(); 
                }                
       });