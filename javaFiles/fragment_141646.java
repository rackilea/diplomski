private class MakePDF extends AsyncTask<Void, Void, Void> {

       private ProgressDialog processingDialog;
            Context cnt = null;

           MakePDF(Context cnt)
                 {
              this.cnt = cnt;
                  }

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();

                    processingDialog = ProgressDialog.show( this.cnt, "Creating PDF", "Please wait ...", true, false);    

                }

                @Override
                protected Void doInBackground(Void... arg0) {
                          createPDF();                 
                         return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                   processingDialog.dismiss();
                   viewPDF();
                    }
            }