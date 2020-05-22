public void onWindowFocusChanged(boolean hasFocus) {
        relative_layout_two = (RelativeLayout) findViewById(R.id.rl2);
        int bottom_position_of_button1 = bt1.getBottom();
        int width_of_button1 = bt1.getWidth();
        bt2 = new Button(getApplicationContext());
        rl.setPadding(0, bottom_position_of_button1-200, 0, 0);// I have taken 200 as the height of second button
        rl.addView(bt2, width_of_button1, 200);

    };