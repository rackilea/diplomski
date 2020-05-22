public void onClick(View v) {

     switch(v.getId()){
     case (R.id.plusbutton):
                 Button myButton = new Button(this);
                 myButton.setText("Add Me");

                 LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
                 LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                 ll.addView(myButton, lp);
                 break;.
     case (R.id.minusbutton):
                 Button myButton = new Button(this);
                 myButton.setText("Remove Me");

                 LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
                 LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                 ll.removeView(myButton, lp);
                 break;
           }
         }