@Override
        protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
       super.onPostExecute(result);
        try {
            JSONObject jobject = new JSONObject(result);
            object = jobject.getJSONObject("userdetail");
            Log.e("result", "result" + object);

            String name = object.getString("user_login");
            int post = object.getInt("month");
            Log.e("name", "name" + name);
            Log.e("name", "post" + post);
            Log.e("result", "result" + resul);
            user = new HashMap<String, String>();
            user.put("name", name);
            dialog.dismiss();
            String s = user.get("name").toString();
            p.name.setText(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }          
    }