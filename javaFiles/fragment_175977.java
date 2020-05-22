builder.setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        // Send the positive button event back to the host activity
        mListener.onDialogPositiveClick(mNameEdit.getText().toString(), mPasswordEdit.getText().toString());
    }
});