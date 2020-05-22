f.addValueEventListener(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot snapshot) {
    String val = (String) snapshot.getValue());
  }

  @Override public void onCancelled() { }
});