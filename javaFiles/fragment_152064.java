if(radioYes.isChecked()){
    Intent intent = new Intent(CurrentActivity.this, PageOne.class);
    CurrentActivity.this.startActivity(intent);
}else if(radioNo.isChecked()){
    Intent intent = new Intent(CurrentActivity.this, PageTwo.class);
    CurrentActivity.this.startActivity(intent);
}else{
    Toast.makeText(getApplicationContext(), "Select the radio button",Toast.LENGTH_LONG).show();
}