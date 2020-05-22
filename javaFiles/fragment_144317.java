CharSequence actions[] = new CharSequence[] {"paste"};
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setCancelable(true);
builder.setItems(actions, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        edittext.setText(readFromClipboard(aContext_));
    }
});
builder.show();