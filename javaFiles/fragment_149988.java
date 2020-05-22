AlertDialog.Builder builderSingle = new  AlertDialog.Builder(MainActivity.this);
builderSingle.setIcon(R.drawable.ic_launcher);
builderSingle.setTitle("Select Language :-");

final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
    MainActivity.this,
    android.R.layout.select_dialog_singlechoice);
arrayAdapter.add("English");
arrayAdapter.add("Arabian");
arrayAdapter.add("Italian");
arrayAdapter.add("French");

builderSingle.setNegativeButton(
    "cancel",
    new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    });

builderSingle.setAdapter(
    arrayAdapter,
    new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // Do whatever you want to do after selection of language
        }
    });
builderSingle.show();