try{
            JSONObject myJson = new JSONObject(str);
            JSONObject entityObject = myJson.getJSONObject("entity");

            // Parsing title
            JSONOBject titleObject = entityObject.getJSONObject("title");
            String grande =  titleObject.getString("$t");

            // Do the same for Description as well (Like above two line)

            Toast.makeText(getActivity(), ""+grande, Toast.LENGTH_SHORT).show();


        } catch ( JSONException e) {
            e.printStackTrace();
   }