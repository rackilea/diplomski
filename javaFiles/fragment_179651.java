protected class Mytask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... params) {
            String Plain_str= null;
            try {
                // Create a URL for the desired page
                URL url = new URL(serwer_url);

                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String str;
                while ((str = in.readLine()) != null) {
                    // str is one line of text; readLine() strips the newline character(s)
                    Plain_str = Plain_str + str; 
                }
                Log.i("Plain read str", Plain_str);
                in.close();


            } catch (MalformedURLException e) {
            } catch (IOException e) {}   

            return Plain_str;
        }
        protected void onPostExecute(String str){
            TextView MainText = (TextView)findViewById(R.id.TextMain);      
            MainText.setText(Html.fromHtml(str.toString()));
        }
    }