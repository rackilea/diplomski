Gson gson = new Gson();

Type type = new TypeToken<HashMap<String, String>>(){}.getType();

HashMap<String, String> map = new HashMap<String, String>();
map = gson.fromJson( json, type );