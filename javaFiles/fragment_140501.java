loginButton.setOnClickListener(new OnClickListener() {
  @Override
  public void onClick(View v) {
          Intent intent = new Intent(v.getContext(), MasterUserActivity.class);
          v.getContext().startActivity(intent);
  }
});