class GetFileInfo extends AsyncTask<String, Integer, String>
{
    protected String doInBackground(String... urls)
    {
                URL url;
                String filename = null;
                try {
                    url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                conn.setInstanceFollowRedirects(false); 

                try {
                    for(int i = 0; i < 10; i++)
                    {
                        url = new URL(conn.getHeaderField("Location")); 
                        conn = (HttpURLConnection) url.openConnection();
                        conn.connect();
                        conn.setInstanceFollowRedirects(false);
                    }
                } catch (Exception e) {
                }

                String depo = conn.getHeaderField("Content-Disposition");
                String depoSplit[] = depo.split(";");
                int size = depoSplit.length;
                for(int i = 0; i < size; i++)
                {
                    if(depoSplit[i].startsWith("filename="))
                    {
                        filename = depoSplit[i].replace("filename=", "").replace("\"", "").trim();
                        Global.error(filename);
                        i = size;
                    }
                }
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e) {
                }
            return filename;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
    }
}