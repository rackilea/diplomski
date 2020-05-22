btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                            String d= date.getText().toString().trim();
                        String t= title.getText().toString().trim();
                        String desc= description.getText().toString().trim();
                        String i= imageURL.getText().toString().trim();
                            Model model = new Model(d,t,desc,i);
                        String id =  databaseReference.push().getKey();
                        databaseReference.child(id).setValue(model);
                            Toast.makeText(MainActivity.this, "Submitted Successfully ", Toast.LENGTH_SHORT).show();
                    }
                });