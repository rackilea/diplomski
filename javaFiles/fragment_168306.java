save.setOnClickListener(new View.OnClickListener() { // if save button clicked

  @Override
  public void onClick(View v) {
 if(checkbox.isChecked()) {
returnIntent.putExtra("outstation", checkbox.getText().toString());
Toast.makeText(getApplicationContext(),checkbox.getText().toString(),Toast.LENGTH_LONG).show();
checkbox.setText("your text here");
      } else {
checkbox.setText("");
}
   }
});