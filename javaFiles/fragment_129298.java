@Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.i("JSON", s);

                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray results = jsonObject.getJSONArray("results");
                    JSONObject jsonObject1 = results.getJSONObject(0);
                    Log.i("results", results.toString());
                    String mQuestion = jsonObject1.getString("question");
                    Log.i("Question", mQuestion);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }