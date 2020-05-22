Map<String, Object> metaData = new HashMap<String, Object>();
metaData.put("title", "myStream");
metaData.put("width", 400);
metaData.put("height", 200);

ns.send("@setDataFrame", "onMetaData", metaData);