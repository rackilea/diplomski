private void loadData() {
        SharedPreferences sharedPre = getSharedPreferences("todoPref",android.content.Context.MODE_PRIVATE);
        Map<String,?> keys = sharedPre.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
                if (entry.getValue().toString().length() > 0) {
                    Log.d("map values",entry.getKey() + ": " + entry.getValue().toString());     
                }
         }
    }