final LinearLayout layout = (LinearLayout)findViewById(R.id.linlayout);
    final LinearLayout f1=(LinearLayout) findViewById(R.id.f1);
    ViewTreeObserver vto = layout.getViewTreeObserver();
    vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
        @Override
        public void onGlobalLayout()
        {
            layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int width = layout.getMeasuredWidth();
            int height = layout.getMeasuredHeight();

            f1.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        }
    });