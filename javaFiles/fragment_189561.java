class MyClickableSpan extends ClickableSpan{     
   String clicked;
   public MyClickableSpan(String string)  
   {
    super();
    clicked =string;
   }
   public void onClick(View tv) 
   {
     // onclick of text in textview do something 
 Toast.makeText(MainActivity.this,clicked ,Toast.LENGTH_SHORT).show();
     //display a toast 
   }
   public void updateDrawState(TextPaint ds)
   {
     ds.setColor(Color.BLUE);//set text color 
     ds.setUnderlineText(true); // set to false to remove underline
   }
  }