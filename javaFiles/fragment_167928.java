public class DownloadTask extends AsyncTask<String, Void, String> {


@Override
protected String doInBackground(String... urls) {

    StringBuilder html = new StringBuilder();
    URL url;
    HttpURLConnection urlConnection = null;

    try {

        url = new URL(urls[0]);

        urlConnection = (HttpURLConnection)url.openConnection();

        InputStream in = urlConnection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        for (String line; (line = reader.readLine()) != null; ) {
              html.append(line);
        }

        return html.toString();

    }
    catch (Exception e){

        e.printStackTrace();

        return "Failed";

    }
    finally{
        in.close();

    }

}