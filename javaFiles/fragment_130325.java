private void deleteQuellenRecord(String _quellenName) {
        String DialogTitel = getString(R.string.daten_delete_titel);
        String DialogText = getString(R.string.daten_delete_text);
        // Dialogdefinition Prograssbar
        dialog = new ProgressDialog(this) {
            @Override
            public boolean onSearchRequested() {
                return false;
            }
        };
        dialog.setCancelable(false);
        dialog.setTitle(DialogTitel);
        dialog.setIcon(R.drawable.icon);
        dialog.setMessage(DialogText);
        // set the progress to be horizontal
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // reset the bar to the default value of 0
        dialog.setProgress(0);
        // set the maximum value
        dialog.setMax(4);
        // display the progressbar
        increment = 1;
        dialog.show();
        // Thread starten
        new Thread(new MyDeleteDataThread(_quellenName)) {
            @Override
            public void run() {
                try {
                    // Datensatz löschen
                    myDB.execSQL("DELETE ... ');");
                    progressHandler
                            .sendMessage(progressHandler.obtainMessage());
                    myDB.execSQL("DELETE ...);");
                    // active the update handler
                    progressHandler
                            .sendMessage(progressHandler.obtainMessage());
                    myDB.execSQL("DELETE ...;");
                    // active the update handler
                    progressHandler
                            .sendMessage(progressHandler.obtainMessage());
                    // Einstellung speichern
                    try {
                        settings.edit().putString("LetzteQuelle", "-1")
                                .commit();
                    } catch (Exception ex) {
                        settings.edit().putString("LetzteQuelle", "").commit();
                    }

                } catch (Exception ex) {
                    // Wait dialog beenden
                    dialog.dismiss();
                    Log.e("Glutenfrei Viewer",
                            "Error in activity MAIN - remove data", ex); // log
                                                                            // the
                                                                            // error
                }
                // Wait dialog beenden
                dialog.dismiss();

            }
        }.start();
        this.onCreate(null);
    }