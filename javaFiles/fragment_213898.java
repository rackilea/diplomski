ExampleTask task = new ExampleTask();
task.execute();


private class ExampleTask extends AsyncTask<Void, Void, String> {
      @Override
      protected Long doInBackground(Void... notUsed) {
         try {
            client = new Socket(hostname, port);
            BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            return is.readLine();

        } catch (Exception e) {
          return "failed " + e.getMessage();
        }

     }

     @Override
     protected void onPostExecute(String result) {
         Vertretungsplan.Cards.add(new VertretungsplanCard("Response:", result));
     }
 }