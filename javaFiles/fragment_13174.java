new AsyncTask<String, Void, String>()
        {

            @Override
            protected String doInBackground(String[] params) {
                try
                {
                    String line;
                    URL url = new URL("http://nomediakings.org/everyoneinsilico.txt");
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                    String str="";
                    while ((line = in.readLine()) != null) {
                        str+=line;
                    }
                    in.close();
                }catch (Exception ex)
                {
                    ex.getMessage();
                }
                return null;
            }
        }.execute("");