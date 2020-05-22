genderButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CloudActivity.this, LoginActivity.class);
        startActivityForResult(intent, 0);
    }
  });