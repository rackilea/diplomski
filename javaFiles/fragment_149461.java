for (int x=0; x<ll.getChildCount(); x++){
  View v = ll.getChildAt(x);
  Class c = v.getClass();
  if(c == LinearLayout.class){
    //Cast to LinearLayout since View doesn't expose a way to access children
    LinearLayout innerLayout = (LinearLayout)v;
    for(int y=0; y<innerLayout.getChildCount() ; y++){
      Button b = (Button)innerLayout.getChildAt(y);

      //Do something with b
    }
  }
 Log.i("test", c.getName());
}