final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parent);
for (int i = 0; i < myArray.size(); i++) {
    final TextView text = new TextView(this);
    text.setText(myArray.get(i));
    linearLayout.addView(text);
}