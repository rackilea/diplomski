private static JsonData<List<ConfigurationProperty>> readconfigFileList() {
    Reader reader = null;
    JsonData<List<ConfigurationProperty>> dataArray = null;
    Gson gson  = null;
    Type confType;
    Type confTypeArray;
    try {
        reader = new FileReader("./config.json");
        gson = new GsonBuilder().create();
        confType = new TypeToken<JsonData<List<ConfigurationProperty>>>() {}.getType();

        dataArray = gson.fromJson(reader,confType);
        System.out.println(dataArray.toString());

    } catch (FileNotFoundException e) {
        e.printStackTrace();
        fail("Test failed while reading the config.json file: "+e.getMessage());        }
    finally {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Test failed while reading the config.json file: "+e.getMessage());
        }
    }
    return dataArray;
}