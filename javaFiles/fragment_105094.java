onCreate(...) {
    ...
   Button myButton1 = (Button)findViewById(R.id.somebutton);
   Button myButton2 =....
}



public void onButtonPressedFromView(View button) {
   switch(button.getId()) {
   case (myButton1.getId()) :
      //do something
      break;
   case (myButton2.getId()) :
      //do something different
      break;
   default :
      //default action
      break;
   }
}