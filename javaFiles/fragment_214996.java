@Override 
public void onStop() { 
    super.onStop(); 
    if (firebaseRecyclerAdapter != null){ 
        firebaseRecyclerAdapter.cleanup(); 
        firebaseRecyclerAdapter.notifyDataSetChanged();
    } 
}