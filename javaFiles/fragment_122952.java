interface EditAlertOkListener
{
    void onEditAlertOk(EditText editText);
}

private void showEditAlert(final EditAlertOkListener listener)
{
    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    ...
    final EditText editText = new EditText(this);
    alert.setView(editText);
    alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            if (listener != null)
                listener.onEditAlertOk(editText);
        }
    }); 

    alert.setNegativeButton(android.R.string.cancel, null);
    alert.show();
}