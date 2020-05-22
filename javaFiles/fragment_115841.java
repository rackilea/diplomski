public void registerCustomEnchants() throws IOException, ParseException {
    JSONArray enchantJSONArray = (JSONArray)new JSONParser().parse(new FileReader(String.valueOf(pathToJSONFile)));
    for(Object o : enchantJSONArray){
        jsonArray.add(o);
    }
    Iterator iterator = jsonArray.iterator();
    while (iterator.hasNext()) {
        JSONObject jsonObject1 = ((JSONObject) iterator.next());
        Iterator<? extends Map.Entry<Object, Object> > it = jsonObject1.entrySet().iterator();
        while(it.hasNext()) {
            String name = null, enchantType = null;
            long maxEnchantLevel =0;
            Map.Entry<Object, Object> pair = it.next();
            if(pair.getKey().equals("name")){
                name = (String) pair.getValue();
            }
            if(pair.getKey().equals("enchant type")){
                enchantType = (String) pair.getValue();
            }
            if(pair.getKey().equals("max enchant level")){
                maxEnchantLevel = (long)pair.getValue();
            }
            parseEnchant(name, enchantType, maxEnchantLevel);
        }
    }
}

public void parseEnchant(String name, String enchantType, long maxEnchantLevel){
    new CustomEnchant(id++, name,enchantType, maxEnchantLevel);
}

/**
 * Creates a sample config with 2 usable items with custom enchants.
 * @throws IOException
 */
private void createDefaultCustomEnchantsJSONFile() throws IOException {
    FileReader fileReader = new FileReader(String.valueOf(pathToJSONFile));

    if (!checkIfDefaultExists()) {
        JSONObject explosiveBowObject = new JSONObject();
        explosiveBowObject.put("max enchant level", 1);
        explosiveBowObject.put("enchant type", "explosive");
        explosiveBowObject.put("name", "Explosive");

        JSONObject poisonBowObject = new JSONObject();
        poisonBowObject.put("max enchant level", 4);
        poisonBowObject.put("enchant type", "poison");
        poisonBowObject.put("name", "Poison");

        jsonArray.add(explosiveBowObject);
        jsonArray.add(poisonBowObject);

        //Enables the pretty version of Gson fortmatting
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonArray);

        //Writes the shit to the file.
        FileWriter fileWriter = new FileWriter(String.valueOf(pathToJSONFile));
        fileWriter.write(json);
        fileWriter.flush();
    }
}