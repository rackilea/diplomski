private String UserName = "";
private void UserPostInformation(final String key) 
{
    DatabaseReference historyDatabase = FirebaseDatabase.getInstance().getReference().child("ThePostting").child(key);
    historyDatabase.addValueEventListener(new ValueEventListener() 
    {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            if (dataSnapshot.exists())
            {
                String IdHistory = dataSnapshot.getKey();
                Long time = 0L;
                String foodname11 = "";
                String imagefood1 = "";
                String s = null;
                String name = "name";
                UserName = "";
                for (DataSnapshot  child : dataSnapshot.getChildren())
                {
                    if (child.getKey().equals("time")) {
                        time = Long.valueOf(child.getValue().toString());

                    }
                    if (child.getKey().equals("FoodName")) {
                        foodname11 = child.getValue().toString();

                    }

                    if (child.getKey().equals("profileImageUrl")) {
                        imagefood1 = child.getValue().toString();
                    }
                    if (child.getKey().equals("UserID")) {


                        s = child.getValue().toString();

                    }
                }

                UserIDGetInfo =  s;


                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(UserIDGetInfo);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() 
                {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists())
                        {
                            Map<String,Object> map = (Map<String,Object>) dataSnapshot.getValue();
                            if (map.get("name")!=null)
                            {
                                UserName= map.get("name").toString();
                            }


                            HistoryObject obj = new HistoryObject(IdHistory , getDate(time),foodname11 , imagefood1 , UserName);
                            resultHistory.add(obj);
                            mhistoryAdapter.notifyDataSetChanged();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

}