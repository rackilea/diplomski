final AlertDialog.Builder warning = new AlertDialog.Builder(this);
...
public void onClick(DialogInterface arg0, int arg1) {
   warning.dismiss();
   findView();
}