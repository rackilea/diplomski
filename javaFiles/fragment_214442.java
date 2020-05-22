// Find your button in the layout.
Button btnMyButton = (Button)findViewById(R.id.btnMyButton);

btnMyButton.setOnClickListener(new OnClickListener() {

  @Override
  public void onClick(View v) {
        Intent i = newIntent(this,NewActivity.class);
        startActivity(i);
  }

});