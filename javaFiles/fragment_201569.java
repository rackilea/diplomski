public void onChildAdded(DataSnapshot dataSnapshot, String s) {
             for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                Event event = new Event();
                event = snapshot.getValue(Event.class);
                events.add(event);
                myRecyclerView.setAdapter(adapter);
          }
            }