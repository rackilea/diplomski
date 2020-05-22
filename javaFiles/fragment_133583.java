LinearLayout buttonsLayout = (LinearLayout)findViewById(R.id.buttons_layout);
    LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    for(int i=0;i<numberOfButtons;i++){
        Button button = new Button(this);
        button.setText("Buttin "+(i+1));
        button.set....other attributes
        buttonsLayout.addView(button, layoutParams);
    }