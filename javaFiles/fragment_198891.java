private void initUI(){
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("activity").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
    Query query = databaseReference.orderByChild("clickTime").limitToLast(3);
    query.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()){
                //now count the children in dataSnapshot
                int totalChildren = (int) dataSnapshot.getChildrenCount();
                if(totalChildren > 2){
                    //now check for this person properly
                    int milliSecInAWeek = 7*24*60*60*1000; //perhaps i m right ;)
                    //now check if the last of the three click was within this week 
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        //well this is actully a loop kind of thing
                        //but we are just conserned about the first most click so we will call return just on the first child itteration :)
                        UserActivity userActivity = snapshot.getValue(UserActivity.class);

                        if(userActivity.getClickTime() - System.currentTimeMillis() < milliSecInAWeek){
                            //this person has clicked thrre times in this week disable the button buddy ;)
                        }else{
                            //this person has got chance(s) to click. let the button be enables :) 
                        }
                        return;
                    }
                }else{
                    //this user has clicked less then 3 times so the let the button be clickable for the user
                }
            }else{
                //there is no activity by this user let the button be clickable
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}

private class UserActivity{

    private float clickTime;

    public UserActivity() {

    }

    public UserActivity(float clickTime) {
        this.clickTime = clickTime;
    }

    public float getClickTime() {
        return clickTime;
    }

    public void setClickTime(float clickTime) {
        this.clickTime = clickTime;
    }
}