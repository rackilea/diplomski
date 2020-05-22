HashMap<String, String> applicationSettings = new HashMap<String,String>();
        for(int i=0; i<settings.length(); i++){
            String value = settings.getJSONObject(i).getString("value");
            String name = settings.getJSONObject(i).getString("name");
            applicationSettings.put(name, value);
        }