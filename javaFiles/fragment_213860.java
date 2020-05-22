public void saveCharacterInfo() {

    JSONObject obj = JSONUtils.getJSONObjectFromFile("/character.json");
    obj.put("day", c.getDay());
    obj.put("name", c.getCharName());
    obj.put("hp", c.getCharHp());
    obj.put("maxHp", c.getCharHpMax());
    obj.put("armor", c.getCharArmor());
    obj.put("speed", c.getCharSpeed());
    obj.put("strength", c.getCharStrength());
    obj.put("money", c.getCharMoney());
    obj.put("food", c.getCharFood());
    obj.put("maxFood", c.getCharMaxFood());
    obj.put("morale", c.getCharMorale());
    obj.put("bait", c.getCharBait());

    try {

        URL resourceUrl = getClass().getResource("/character.json");
        File file = new File(resourceUrl.toURI());
        file.getParentFile().mkdirs();
        file.delete();
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(obj.toString());
        writer.flush();
        writer.close();

    } catch (Exception e) {
    }
}