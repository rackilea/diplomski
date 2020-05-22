public class SendJsonArrayToServer extends AsyncTask<String, String, String>
{
    String jsonData;
    private String JsonResponse;
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd.setMessage("Saving...");
        pd.show();
    }

    @Override
    protected String doInBackground(String... params)
    {
        String jsonResponse = null;
        String jsonData = params[0];

        try
        {
            URL url = new URL("http://xxxxxxxxxxxxx/xxxxxxxxxxxxx");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(jsonData);
            writer.close();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0)
            {
                // Stream was empty. No point in parsing.
                return null;
            }
            JsonResponse = buffer.toString();

            //send to post execute
            return JsonResponse;


        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);

        try {
            urlConnection.disconnect();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pd.dismiss();

    }