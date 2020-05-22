listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
final String selectedFromList = (String) listview.getItemAtPosition(position);
DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Accounts").child("user").child(useruid);
ref.orderByChild("name").equalTo(selectedFromList).addValueEventListener(new ValueEventListener(){
 @Override
 public void onDataChange(DataSnapshot dataSnapshot) {

  //update values here
     }
  }

   @Override
 public void onCancelled(FirebaseError firebaseError) {

            }
        });
    });