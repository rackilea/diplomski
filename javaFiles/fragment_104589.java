btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String d= date.getText().toString().trim();
                        String t= title.getText().toString().trim();
                        String desc= description.getText().toString().trim();
                        String i= imageURL.getText().toString().trim();
                            Model model = new Model(d,t,desc,i);
                        String id =  databaseReference.push().getKey();
                        databaseReference.push().setValue(model);
                            Toast.makeText(MainActivity.this, "Submitted Successfully ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        Toast.makeText(MainActivity.this, "Error Occured !", Toast.LENGTH_SHORT).show();
                    }
                });