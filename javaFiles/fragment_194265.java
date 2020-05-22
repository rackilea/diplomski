private class ParseByGson extends AsyncTask<String,Void,FullContents> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected FullContents doInBackground(String... params) {
        FullContents fullContents = null;
        try {
            URL url=new URL(params[0]);
            InputStreamReader reader=new InputStreamReader(url.openStream(),"UTF-8");
            fullContents=new Gson().fromJson(reader,FullContents.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fullContents;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(FullContents results) {
        super.onPostExecute(results);
        ObjectKey objectKey = results.getContact().get(0);
        Log.e(">>",objectKey.getKey1()+"--");
    }
}