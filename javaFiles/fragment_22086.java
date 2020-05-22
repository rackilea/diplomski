btnMenuDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(SupplierMaintenance.this);
            builder.setTitle("DELETE Supplier");
            builder.setMessage("You are about to delete the selected supplier. Continue?");
            builder.setCancelable(false);
            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //DELETE METHOD
                    databaseSupp = FirebaseDatabase.getInstance().getReference("SUPPLIERS");
                    final DatabaseReference mDatabase2 = databaseSupp;

                    mDatabase2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull final DataSnapshot dataSnapshot2) {

                            for (final DataSnapshot snapshot : dataSnapshot2.getChildren()) {
                                if (snapshot.child("Supplier_Name").getValue(String.class).equals(suppName.getText().toString())) {
                                    deletekey = snapshot.getKey().toString();
                                    keyholder.setText(deletekey);
               mDatabase2.child(keyholder.getText().toString()).removeValue();  
                                     return;
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            });

            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            //DELETE METHOD END
        }
    });