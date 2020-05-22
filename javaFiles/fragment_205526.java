btnA1.setOnLongClickListener(new Button.OnLongClickListener() {
  @Override
  public boolean onLongClick(View v) {
    Toast.makeText(getApplicationContext(),ttlA1,Toast.LENGTH_SHORT).show();
    dialogForm(btnA1); // <---- add this
    return true;
  }
});