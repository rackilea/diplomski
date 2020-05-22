public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // other code

    builder = new AlertDialog.Builder(getActivity());
    builder.setMessage("Do you want to save your Notes?");
    builder.setCancelable(false);

    builder.setPositiveButton("Yes",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    saveNotes();
                }
            });

    builder.setNegativeButton("No",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

    alertSave = builder.create();


    builder.setPositiveButton("Yes",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    saveNotes();
                    finish();
                }
            });

    builder.setNegativeButton("No",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    finish();
                }
            });

    alertBack = builder.create();

    ImageButton savebutton = (ImageButton)view.findViewById(R.id.savebutton);
    savebutton.setOnClickListener(new ImageButton.OnClickListener() {

        public void onClick(View v) {
            alertSave.show();
        }
    });
    // other code
}

public boolean onKeyDown(int keyCode, KeyEvent event)
{
    if(keyCode == KeyEvent.KEYCODE_BACK) {
        alertBack.show();
        return true; // shows you consumed the event with your implementation
    }
    // blah, blah, other code
}        


private void saveNotes() {
    String Notes = notes.getText().toString();
    Uri updateUri = ContentUris.withAppendedId(STITCHES_URI, rowID);
    ContentValues values = new ContentValues();
    values.put("stitchnotes", Notes);
    getActivity().getContentResolver().update(updateUri,values,null,null);
}