String[] names = { "button1", "button2", "button3", "button4" };

LinearLayout layout = (LinearLayout) findViewById(R.id.linear);

for (int i = 0; i < 4; i++) {
    Button button = new Button(this);
    button.setText(names[i]);
    button.setId(i);
    button.setBackgroundColor(Color.BLUE);

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    params.setMargins(20, 0, 20, 20); // (left, top, right, bottom)
    button.setLayoutParams(params);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // finish later
        }

    });
    layout.addView(button);