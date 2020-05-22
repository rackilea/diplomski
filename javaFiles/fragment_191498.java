public class RemoveDialog extends AsyncTask<Void, Void, Void> {

    ProgressDialog asyncDialog;

    public RemoveDialog(Context c) {
        asyncDialog = new ProgressDialog(c);
    }

    @Override
    protected void onPreExecute() {
        //set message of the dialog
        asyncDialog.setTitle("Please wait");
        asyncDialog.setMessage("Loading...");
        asyncDialog.setCancelable(false);

        //show dialog
        asyncDialog.show();

        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        //hide the dialog
        asyncDialog.dismiss();

        super.onPostExecute(result);
    }
}