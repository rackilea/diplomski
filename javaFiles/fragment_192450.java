@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    dataSnapshot.child("bmark").getRef().setValue("Solved");
    // Here you need to save the value in the arraylist.   
    bookslist.get(position).setMardid("Here what ever the value you will pass will get updated on the button after notify"); //Try adding the static string that you want after button click.
    notifyItemChanged(position)
}