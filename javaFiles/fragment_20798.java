Gson gson = new GsonBuilder()
    .enableComplexMapKeySerialization()
    .serializeNulls()
    .setDateFormat(MY_DATE_FORMAT)
    .create();
CometCallback cometCallback = gson.fromJson(jsonFile, CometCallback.class) ;