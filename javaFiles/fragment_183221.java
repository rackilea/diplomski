final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        mTestArray , android.R.layout.simple_spinner_item);

        String item = list.get(position);


@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    if (selectionCurrent != position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle(R.string.dialogtitle);

        //set dialog message
        alertDialogBuilder.setMessage(R.string.dialogtext).setCancelable(false)
                .setPositiveButton(R.string.si,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        // if this button is clicked,
                        Toast.makeText(context, "Eliminar", Toast.LENGTH_SHORT).show();
                    }
                }) .setNegativeButton(R.string.no
                , new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, do nothing
                dialog.cancel();
            }
        });
        alertDialogBuilder.setView(spinner);
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
    selectionCurrent = position;
}