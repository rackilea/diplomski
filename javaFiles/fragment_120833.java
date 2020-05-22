LinearLayout content = findViewById(R.id.content);
for (int x=0;x<10;x++) {
        RelativeLayout element = new RelativeLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 400);
        params.setMargins(0, 0, 0, 100); // now should work
        element.setLayoutParams(params);
        element.setBackgroundResource(R.color.green);
        content.addView(element);
    }