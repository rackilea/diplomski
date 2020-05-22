private void addBorderedView(Context context, LinearLayout layout, String string_to_display) {
    String[] array = string_to_display.split("");
    for (int i = 1; i < array.length; i++) {
        TextView borderedTextView = (TextView) LayoutInflater.from(context).inflate(R.layout.border_text_view, null);
        borderedTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        borderedTextView.setGravity(Gravity.CENTER);
        borderedTextView.setText(array[i]);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) borderedTextView.getLayoutParams();
        params.setMargins(2, 0, 2, 0); //substitute parameters for left, top, right, bottom
        borderedTextView.setLayoutParams(params);
        layout.addView(borderedTextView);
    }
}