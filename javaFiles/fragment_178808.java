// Do this in your onCreate method and store the references as class member variables
showDisplay1 = (LinearLayout)findViewById(R.id.display1);
showDisplay2 = (LinearLayout)findViewById(R.id.display2);
showDisplay3 = (LinearLayout)findViewById(R.id.display3);

// Do this somehwere in your code
showDisplay1.setVisibility(isA?View.VISIBLE:View.GONE);
showDisplay2.setVisibility(isB?View.VISIBLE:View.GONE);
showDisplay3.setVisibility(isC?View.VISIBLE:View.GONE);