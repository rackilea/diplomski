databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot!=null)
        {
          String userDepartment = dataSnapshot.child("userDepartment").getValue());
          //Now check with this userDepartment
          if (userDepartment .equals("Administrator")) {
             startActivity(new Intent(MainActivity.this, SecondActivity.class));
          } else {
            startActivity(new Intent(MainActivity.this, LocalUserDashboard.class));
        }
    }

}