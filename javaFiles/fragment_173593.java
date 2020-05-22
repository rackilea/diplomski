findViewById(R.id.note).setOnClickListener(new OnClickListener() {
  @Override
  public void onClick(View v) {
    startActivity(new Intent(LaunchActivity.this, CreateNote.class));
  }
});