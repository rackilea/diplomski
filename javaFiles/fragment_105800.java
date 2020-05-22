if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
    final android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) context
            .getSystemService(Context.CLIPBOARD_SERVICE);
    final android.content.ClipData clipData = android.content.ClipData
            .newPlainText("text label", "text to clip");
    clipboardManager.setPrimaryClip(clipData);
} else {
    final android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) context
            .getSystemService(Context.CLIPBOARD_SERVICE);
    clipboardManager.setText("text to clip");
}