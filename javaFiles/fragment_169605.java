LayoutInflater inflater = this.getLayoutInflater();
AlertDialog.Builder builder = new AlertDialog.Builder(this);
final View dialogView = inflater.inflate(R.layout.dialog_alert, null);
builder.setView(dialogView);
builder.setMessage("Lag en spiller");
builder.setCancelable(true);
builder.setPositiveButton("Ok",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                EditText editText = (EditText) dialogView.findViewById(R.id.d_alert_et);
                Log.v("tag", "Edit text value: " + editText.getText());
            }
        });
builder.setNegativeButton("no",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
AlertDialog alert = builder.create();
alert.show();