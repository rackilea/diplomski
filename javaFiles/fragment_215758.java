public void setButtonParams(Button button){
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setAllCaps(false);
        button.setTextScaleX(0.92f);
        button.setPadding(20, 20, 20, 20);
        button.setBackgroundColor(Color.parseColor("#70553B"));
        button.getBackground().setAlpha(20);

        button.setMaxLines(1);
        button.setGravity(Gravity.CENTER);
   }
   for (int i = 1; i < 4; i++) {

        Button button = new Button(this);
        button.setId(i);
        button.setLayoutParams(params);
        setButtonParams(button);
        button.setOnClickListener(this);
        buttonHolder[i] = button;
        side_a.addView(button);
    }