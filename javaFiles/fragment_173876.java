public class ParseXMLTask extends AsyncTask<Void, Void, String[]>
{

    private ProgressDialog dlg;

    @Override
    protected void onPostExecute(String[] result)
    {
        dlg.dismiss();
        if (result[0] == "steve")
        {
            sayHiToSteve();
        }

        super.onPostExecute(result);
    }

    @Override
    protected void onPreExecute()
    {
        dlg = new ProgressDialog(MyActivity.this);
        dlg.setMessage("Parsing...");
        dlg.setCancelable(false);
        dlg.setIndeterminate(true);
        dlg.show();

        super.onPreExecute();
    }

    @Override
    protected String[] doInBackground(Void... params)
    {
        return parseXmlFile();
    }

}