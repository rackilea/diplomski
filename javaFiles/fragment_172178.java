@Override
public void onStart() {
    super.onStart();
    AlertDialog alertDialog = (AlertDialog) getDialog();
    if (alertDialog != null) {
        mOKButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (field OK) {
                    // save data
                    dismiss();
                } else {
                    // show error dialog
                }
            }
        });
    }
}