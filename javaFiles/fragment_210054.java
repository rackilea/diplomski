AlertDialog.Builder builder = new AlertDialog.Builder(Home.theContext);
            builder.setMessage(R.string.confirm_delete);
            builder.setCancelable(true);
            builder.setPositiveButton(R.string.confirm_yes, vCabDelete());
            builder.setNegativeButton(Home.theContext.getString(R.string.confirm_no), null);
            AlertDialog dialog = builder.create();
            dialog.show();

....

private static DialogInterface.OnClickListener vCabDelete() {
    return new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface di, int id) {
            ....
        }
    };
}