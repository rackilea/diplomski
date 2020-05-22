query.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
         // data has been fetched, hide progress and update adapter data
          heFrProgressBar.setVisibility(View.GONE);
         // set the new data to the adapter
         healAdapter.notifyDataSetChanged();
    }
});





@Override
    public void onStart() {
        super.onStart();
       healAdapter.startListening();
    }