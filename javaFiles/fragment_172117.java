AlertDialog.Builder builder = new AlertDialog.Builder(YourMainActivity.this, R.style.AlertDialogCustom);
builder.setTitle(getResources().getString(R.string.title));
builder.setMessage(getResources().getString(R.string.exit_dialog));
builder.setPositiveButton(getResources().getString(R.string.ok_dialog), new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
                         YourMainActivity.this.finish();
                                }
                            });
builder.setNegativeButton(getResources().getString(R.string.cancel_dialog), null);
builder.show();