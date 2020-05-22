for (int i = 0; i < 5; i++) {
        Button button = new Button(getApplicationContext());
        button = new Button(getApplicationContext());
        button.setId(i+1);
        button.setText("" + i);
        relativelayout.addView(button);
        bList[i] = button;
    }