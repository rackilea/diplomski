JSONObject object = new JSONObject(jsonResult);

            JSONOArray details = object.getJSONArray("Details");

           for (int i = 0; i < details.length(); i++) {
             JSONObject c = details.getJSONObject(i);

            String status = c.getString("Status");
            }
            Toast.makeText(getBaseContext(), "Please wait...",100).show();