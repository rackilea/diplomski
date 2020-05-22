public class PerformNetworkTasks extends AsyncTask<String, String, List<String>> {

    @Override
    protected List<String> doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect(); //getting the connection to the URL to read JSON data
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            String jsonText = buffer.toString(); // gets what the URL returns as JSON


            JSONObject obj = new JSONObject(jsonText); // using JSONObject to pass to a JSONArray to search for the JSON

            List<String> allInfo = new ArrayList<>(); // list to put all the returned information

            JSONArray linemanques = obj.getJSONArray("linemanques"); //selects the array to read from
            for (int i = 0; i < linemanques.length(); i++) {

                JSONObject questionParts = linemanques.getJSONObject(i);
                quesnum = questionParts.getString("quesnum"); // all of questionParts.getString() are for getting the data in the JSONArray
                questype = questionParts.getString("questype");
                question = questionParts.getString("question");
                ans1 = questionParts.getString("ans1");
                ans2 = questionParts.getString("ans2");
                ans3 = questionParts.getString("ans3");
                ans4 = questionParts.getString("ans4");
                correctans = questionParts.getString("correctans");
                category = questionParts.getString("category");
                notes = questionParts.getString("notes");
                flag = questionParts.getString("flag");


                allInfo.add(quesnum);
                allInfo.add(questype);
                allInfo.add(question);
                allInfo.add(ans1);
                allInfo.add(ans2);
                allInfo.add(ans3);
                allInfo.add(ans4);
                allInfo.add(correctans);
                allInfo.add(category);
                allInfo.add(notes);
                allInfo.add(flag);
                allInfo.add("\n");
            }

            return allInfo;
             /*
              right now
              I am returning the list as a String,
              so that I can actually view the data.
              I need to put this data into their own TextViews.
              So how can I return the list I have so that I can set
              the individual TextViews as one section from the list?
              */

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
        }
        if (connection != null) {
            connection.disconnect();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    protected void onPostExecute(List<String> result) {
        super.onPostExecute(result);
        inputDataTV.setText(result.get(0));
    }
}