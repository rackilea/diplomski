public void addStudent() {
// add the 'add' button view to the oncreatemethod 
//        add = (Button) findViewById(R.id.AddStudent);

        add.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
//                  Do not restart the activity that opened this activty
//                  this activity is anyways on top of the MainActivity. Just finish this activty setting the result

//                Intent intent = new Intent(AddActivity.this, MainActivity.class);
//                intent.putExtra("studentName",name.getText().toString() );
//                intent.putExtra("phoneNumber",phone.getText().toString());
//                startActivity(intent);

//                How to do that? 
                Student student = new Student(Fname, FphoneNumber);
                Intent intent = new Intent();
                intent.putExtra(YOUR_KEY, Parcels.wrap(student));
                // you can also do it without the parcels lib 
//                intent.putExtra("studentName",name.getText().toString() );
//                intent.putExtra("phoneNumber",phone.getText().toString());

                setResult(123,intent); // set the result code. it should be the same one as the one your listening on in MainAcitivty

                // then just finish this activity. 
                finish();
                // this calls the onActivtyResultMethod in MainActivity which furtther does the logic 
//                students.add(student);

            }
        });
    }