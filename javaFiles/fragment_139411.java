TextView textView = new TextView(context);
textView.setGravity(Gravity.CENTER);
textView.setPadding(10, 50, 10, 10);
textView.setText(title);
textView.setTextColor(Color.BLACK);
textView.setTextSize(20);

Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
textView.setTypeface(boldTypeface);

AlertDialog.Builder builder = new AlertDialog.Builder(context);
builder
        .setCustomTitle(textView)
        .setMessage(message)
        .setPositiveButton("Ok", listener);

AlertDialog customDialog = builder.show();

TextView messageText = customDialog.findViewById(android.R.id.message);
if (messageText != null) {
    messageText.setGravity(Gravity.CENTER);
    messageText.setTextColor(Color.GRAY);
} else {
    Log.w(TAG, "messageText is null");
}