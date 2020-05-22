private class RunningAlternativSearch extends
            AsyncTask<Integer, Integer, Void> {


        final ProgressDialog dialog = new ProgressDialog(SearchResult.this) {
            @Override
            public boolean onSearchRequested() {
                return false;
            }
        };



        @Override
        protected void onPreExecute() {
            alternativeSucheBeendet = false;
            String DialogTitel = getString(R.string.daten_wait_titel);
            DialogText = getString(R.string.dialog_alternativ_text);
            DialogZweiteChance = getString(R.string.dialog_zweite_chance);
            DialogDritteChance = getString(R.string.dialog_dritte_chance);
            sucheNach = getString(R.string.dialog_suche_nach);
            dialog.setCancelable(true);
            dialog.setTitle(DialogTitel);
            dialog.setIcon(R.drawable.icon);
            dialog.setMessage(DialogText);
            dialog.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface arg0) {
                    // TODO Auto-generated method stub
                    cancleBarcodeWorker();
                    if (alternativeSucheBeendet==false){
                        // Activity nur beenden wenn die Suche
                        // nicht beendet wurde, also vom User abgebrochen
                        Toast toast = Toast.makeText(SearchResult.this, SearchResult.this
                                .getString(R.string.toast_suche_abgebrochen),
                                Toast.LENGTH_LONG);
                        toast.show();
                        myDB.close();
                        SearchResult.this.finish();
                    }
                }
            });
            dialog.show();
        }


        ...