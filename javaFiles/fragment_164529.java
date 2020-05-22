int btnCount = 10;
    final LinearLayout layout = (LinearLayout) findViewById(R.id.action_bar);
    for (int i = 0; i < btnCount; i++) {
        layout.addView(new Button(this),new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }
    layout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            for(int i = 0; i<layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if(view instanceof Button) {
                    LinearLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int horizontalMargin = r.nextInt(Math.abs(SCREEN_WIDTH - view.getWidth()));
                    layoutParams.setMargins(horizontalMargin, 50, 0, 0);
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    });
    layout.requestLayout();