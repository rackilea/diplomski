public class phpGET extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {

            try {

                URL url = new URL("http://www.domain.com/example.php?auth=David+Cameron");
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                is.close();

            } catch (Exception e) {

                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();

            }

            return null;
        }
    }