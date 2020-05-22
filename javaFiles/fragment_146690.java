TextView aText = (TextView )findViewById(R.id.textview);
String text = aText .getText().toString();

Intent myIntent = new Intent(view.getContext(),Cart.java);
myIntent.putExtra("mytext",text);
startActivity(myIntent);