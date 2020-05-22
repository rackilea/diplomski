public class doit extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        try {
            Document doc = Jsoup.connect("http://www.rfebs.es/estadisticas/2017/liga/B_res.php").get();
            return doc.text();
        } catch (Exception e) {
            e.printStackTrace();
        } return null;
    }

    @Override
    protected void onPostExecute(String result) {
        texx.setText(result);
    }
}