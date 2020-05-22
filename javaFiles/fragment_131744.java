public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
  for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
    String value = childSnapshot.child("current_units").getValue(String.class);
    Log.d("onDataChange", "current_units="+value);
    textView17.setText(value);
  }
}