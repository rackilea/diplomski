Json json = new Json();
json.setTypeName(null);
json.setUsePrototypes(false);
json.setIgnoreUnknownFields(true);
json.setOutputType(OutputType.json);

// I'm using your file as a String here, but you can supply the file as well
Data data = json.fromJson(Data.class, "{\"table\": [{\"id\": 1},{\"id\": 2},{\"id\": 3},{\"id\": 4}]}");