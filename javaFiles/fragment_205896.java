AlertDialog.Builder builder = new AlertDialog.Builder(Kviz.this);

builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog,int which) {
    Editable ukucanoIme = input.getText();
    finish();
});


builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
         dialog.dismiss();
         finish();
         dialog.cancel();
    }
});

AlertDialog dialog = builder.create();