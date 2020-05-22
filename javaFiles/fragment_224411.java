case COLUMNS_DIALOG:
    AlertDialog.Builder columnBuilder = new AlertDialog.Builder(this);
    columnBuilder.setTitle("Columns");
    columnBuilder.setItems(columns, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            bundle.putString("column", columns[which]);
            dialog.dismiss();
            configureString(); // <-- NEW!
        }
    });
    dialog = columnBuilder.create();
    break;