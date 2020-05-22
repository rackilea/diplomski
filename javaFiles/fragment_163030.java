AlertDialog dialog = null;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage(getString(R.string.dialog_message_select))
    .setTitle(getString(R.string.dialog_title_attention));
    builder.setPositiveButton(R.string.male, new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int id)
        {
            mPerson.setGender(Gender.male);
            dialog.dismiss();
            postSelection();
        }
    });
    builder.setNegativeButton(R.string.female, new DialogInterface.OnClickListener()
    {

        @Override
        public void onClick(DialogInterface dialog, int arg1)
        {
            mPerson.setGender(Gender.female);
            dialog.dismiss();
            postSelection(); 
        }
    });

    dialog = builder.create();
    dialog.show();
}