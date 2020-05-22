params = new LinearLayout.LayoutParams(
               LinearLayout.LayoutParams.FILL_PARENT, 
           LinearLayout.LayoutParams.WRAP_CONTENT);

      LinearLayout layout = new LinearLayout(this);
      layout.setOrientation(LinearLayout.VERTICAL);

      TextView tv = new TextView(this);
      ourSurfaceView = new SurfGame(this);

        testbox = new LinearLayout.LayoutParams(widthx,heighty/30);
    layout.addView(tv,testbox);
    layout.addView(ourSurfaceView,params);
    setContentView(layout);