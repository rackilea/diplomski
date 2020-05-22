myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final List<generater> mList = new ArrayList<>();
                    for(DataSnapshot ds:dataSnapshot.getChildren()){
                        String name,was,preis;

                        for(DataSnapshot childSnapShot:ds.getChildren()){
                            if(childSnapShot.getKey().equals("Name")){
                                name=childSnapShot.getValue().toString();
                            }
                            if(childSnapShot.getKey().equals("Was")){
                                was=childSnapShot.getValue().toString();
                            }
                            if(childSnapShot.getKey().equals("Preis")){
                                preis=childSnapShot.getValue().toString();
                            }

                        }
                        generater generater = new generater(name , was , preis);
                        mList.add(generater);
                    }
                    RecyclerView recyclerView = findViewById(R.id.anzeigen_list);
                    final List<generater> mList = new ArrayList<>();
                    RecyclerView.Adapter adapter = new generater_anzeigen_setter(this,mList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });