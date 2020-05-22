public void salas(){
            FirebaseAuth autenticacao = FirebaseAuth.getInstance();
            String emailUsu= autenticacao.getCurrentUser().getEmail();
            reference.orderByChild("email").equalTo(emailUsu).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot datas: dataSnapshot.getChildren()){
                        nomeProf= datas.child("nome").getValue().toString();


                    if(nomeProf != null) {
                referenceSalas.orderByChild("nomeProf").equalTo(nomeProf).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot datas : dataSnapshot.getChildren()) {
                            salasAula += datas.getKey();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        throw databaseError.toException();
                    }
                });
                if (!salasAula.equals(""))
                    txtSalas.setText(salasAula);
                else
                    Toast.makeText(getActivity(), "you dont teach any class yet"/*"Você não dá aula a nenhuma sala ainda"*/, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();

            }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    throw databaseError.toException();
                }
            });

        }