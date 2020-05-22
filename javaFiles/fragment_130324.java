public void daten_remove_on_click(View button) {
        // Nachfragen
        if (spinadapter.getCount() > 0) {
            AlertDialog Result = new AlertDialog.Builder(this)
                    .setIcon(R.drawable.icon)
                    .setTitle(getString(R.string.dialog_data_remove_titel))
                    .setMessage(getString(R.string.dialog_data_remove_text))
                    .setNegativeButton(getString(R.string.dialog_no),
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialogInterface, int i) {
                                    // Nicht löschen
                                    dialogInterface.cancel();
                                }
                            })
                    .setPositiveButton(getString(R.string.dialog_yes),
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialogInterface, int i) {
                                    String _quellenName = myCursor.getString(1);
                                    deleteQuellenRecord(_quellenName);
                                    zuletztGelöscht = _quellenName;
                                }
                            }).show();
        } else {
            // Keine Daten mehr vorhanden
            Toast toast = Toast.makeText(Daten.this,
                    getString(R.string.dialog_data_remove_empty),
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }