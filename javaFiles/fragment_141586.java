String filePath = "pathofjson\\test.json";
    FileReader reader = new FileReader(filePath);

    JSONParser jsonParser = new JSONParser();
    try {
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray lang= (JSONArray) jsonObject.get("AppIcon");
        System.out.println(lang);
        for(int i=0; i<lang.size(); i++){
            System.out.println(lang.get(i));

        }


    } catch (org.json.simple.parser.ParseException e) {
        e.printStackTrace();
    }