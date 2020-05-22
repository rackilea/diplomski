private ContactListAdapter mAdatper;

    public void addGroupAdapter() {
        Firebase jsonurl = new Firebase("firebase url");
        jsonurl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    Log.i("Response Array fire",new JSONArray(dataSnapshot.getValue(String.class)).toString());
                    if (!adapted){
                        mAdatper = new ContactListAdapter(getContext(),dataSnapshot);
                        chatLists.setAdapter(mAdapter);
                        adapted = true;
                    }else {
                        Log.i("update",dataSnapshot.getValue(String.class));
                        mAdatper.setContactList(dataSnapshot);                
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }