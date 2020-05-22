private void addParagraphs(LinearLayout layout, String[] paragraphs) {
    for (String paragraph : paragraphs) {
        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(30);    
        tv.setTypeface(FontFactory.getBFantezy(getBaseContext()));
        layout.addView(tv);
        tv.setText(paragraph);  

        ImageView divider = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 5);
        params.setMargins(10, 10, 10, 10);
        divider.setLayoutParams(params);
        divider.setBackgroundColor(Color.BLUE);

        layout.addView(divider);
    }
}