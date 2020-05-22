LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
// Instantiate a new Gson instance.
        Gson gson = new Gson();

        // Convert the ordered map into an ordered string.
        String json = gson.toJson(data, LinkedHashMap.class);

        // Print ordered string.
        Log.e("list", ""+json); //  {"0" : "816444014066","1" : "747083010945","2" : "816444010969"}