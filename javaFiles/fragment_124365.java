DatabaseReference mReferenceCpf = FirebaseDatabase.getInstance().getReference();
databaseReference.child("Usuario").child(uId).child("cnpjCpf")
        .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             cpf = dataSnapshot.getValue(String.class);
                txtCpf.setText(cpf);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



   DatabaseReference mReferencePlaca = FirebaseDatabase.getInstance().getReference();
    mReferencePlaca.child("Funcionario").child(cpf).child("placa")
            .addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    placa = dataSnapshot.getValue(String.class);
                    txtPlaca.setText(placa);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });