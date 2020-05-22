private void openDialog(String title, final OnOk onOk) {
    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
    builder.setTitle(title);

    final EditText input = new EditText(view.getContext());
    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
    builder.setView(input);

    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
         //Oi, look at this line!
         onOk.hereIsYourText(input.getText().toString());
    }
});
builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
        //TODO: you should handle this event as well! 
    }
});
    builder.show();
}