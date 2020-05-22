@Override
protected Dialog onCreateDialog(int id, Bundle b) {
    LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
    AlertDialog.Builder builder = null;
    switch(id) {
        case DIALOG_BLOCK_SIZE:
        {
            Dialog dialog = new Dialog(this);
            final View dialogLayout = inflater.inflate(R.layout.dialog_block_size, null);
            builder = new AlertDialog.Builder(this);
            builder.setView(dialogLayout);
            builder.setTitle("Set Block Size");

            final EditText blockIn = (EditText)dialogLayout.findViewById(R.id.block_size_in);
            blockIn.setText(new Integer(pref.getInt("block_size", 6)).toString());

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt("block_size", new Integer(blockIn.getText().toString()));
                        editor.commit();
                        ////////TODO///////////
                        //notify MinutemaidService that we have changed the block_size
                        dialog.dismiss();
                    }
                });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
            dialog = builder.create();
            return dialog;
        }
        default:
        {
            return null;
        }
    }
    return dialog;
}