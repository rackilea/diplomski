private void AlertDialogView() {
    final CharSequence[] items = { "One", "Two", "Three", "Four" };

    AlertDialog.Builder builder = new AlertDialog.Builder(ShowDialog.this);//ERROR ShowDialog cannot be resolved to a type
    builder.setTitle("Alert Dialog with ListView and Radio button");
    builder.setSingleChoiceItems(items, -1,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    Toast.makeText(getApplicationContext(), items[item],
                            Toast.LENGTH_SHORT).show();
                }
            });

    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Toast.makeText(ShowDialog.this, "Success", Toast.LENGTH_SHORT)
                    .show();
        }
    });

    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Toast.makeText(ShowDialog.this, "Fail", Toast.LENGTH_SHORT)
                    .show();
        }
    });

    AlertDialog alert = builder.create();
    alert.show();
}