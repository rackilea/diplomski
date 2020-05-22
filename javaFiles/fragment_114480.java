public void showDialogAndGetResult(final int title, final String message, final String initialText, final OnDialogResultListener listener) {
// additional View - use appropriate View to your needs:
final EditText editText = new EditText(this);
editText.setText(initialText);

new AlertDialog.Builder(MainActivity.this)//
    .setTitle(title)//
    .setMessage(message)//
    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (listener != null) {
                listener.onDialogResult(editText.getText().toString());
            }
        }
    })//
    .setNegativeButton(android.R.string.cancel, null)//
    .setView(editText)//
    .show();
}