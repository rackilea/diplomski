AlertDialog alert;
// Alert dialog box method
private void Details(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle);

    builder.setMessage("Please subscribe to use the premium version")
            .setCancelable(false)
            .setPositiveButton( getResources().getString(R.string.ok), new DialogInterface.OnClickListener()
            {
                public void onClick(final DialogInterface dialog, int id) {

                }
            }
            );


    //dialog box details
    alert = builder.create();
    alert.setTitle("Enter Details");
    alert.show();
}