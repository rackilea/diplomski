final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.someView);

myView.getViewTreeObserver().addOnGlobalLayoutListener(new   ViewTreeObserver.OnGlobalLayoutListener() {
  @Override
  public void onGlobalLayout() {  
     //LinearLayout linearLayout = (LinearLayout)findViewById(R.id.someView);
     if(linearLayout != null && linearLayout.getVisibility() == View.VISIBLE)   {
        linearLayout.setVisibility(View.GONE);
     }
...
  }  
});