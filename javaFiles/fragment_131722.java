Button LocationPageButton = (Button) findViewById(R.id.btnLocationPage);
LocationPageButton.setOnClickListener(new View.OnClickListener({
     public void onClick(View _view) {
     Intent i = new Intent(MainActivity.this,TheActivityTheclassNameYouWannGoTo.class);
     startActivity(i);
     }
}));