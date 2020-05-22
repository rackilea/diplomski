private void dialogForm(final Button b1){ //<-- add this
dialog = new AlertDialog.Builder(MainActivity.this);
inflater = getLayoutInflater();
dialogView = inflater.inflate(R.layout.macro_form, null);
dialog.setView(dialogView);
dialog.setCancelable(true);
dialog.setIcon(R.mipmap.ic_launcher);
dialog.setTitle("Macro Form");

txtMacroName    = (EditText) dialogView.findViewById(R.id.txtMacroName);
txtMacroStatus    = (EditText) dialogView.findViewById(R.id.txtMacroValue);

dialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
  @Override
  public void onClick(DialogInterface dialog, int which) {
    macroName    = txtMacroName.getText().toString();
    macroStatus    = txtMacroStatus.getText().toString();
    b1.setText(macroName); // <---- add this
    dialog.dismiss();
  }

});

dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
  @Override
  public void onClick(DialogInterface dialog, int which) {
    dialog.dismiss();
  }
});
dialog.show();
}