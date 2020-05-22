try {

            JSONObject jsonObject = new JSONObject(sb);
            JSONArray array = jsonObject.getJSONArray("objects");

            String key = array.getJSONObject(0).getString("api_key");
            String uname = array.getJSONObject(0).getString("username");
            Toast.makeText(HelloWorldActivity.this, username + " " + key,
                    Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }