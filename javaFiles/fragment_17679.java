String string = "{\"sensors\":[{\"name\":\"steamTemp\",\"data\":\"181.39\",\"state\":1,\n{\"name\":\"waterTemp\",\"data\":\"-713.15\",\"state\":0,\n{\"name\":\"waterFlow\",\"data\":\"0.00\",\"state\":3,\n{\"name\":\"dieselFlow\",\"data\":\"0.00\",\"state\":2,\n{\"name\":\"manualResetLevel\",\"data\":\"1\",\"state\":0,\n{\"name\":\"waterFeederLevel\",\"data\":\"1\",\"state\":0,\n{\"name\":\"autoResetPressure\",\"data\":\"1\",\"state\":0,\n{\"name\":\"manualResetPressure\",\"data\":\"1\",\"state\":0},\n{\"name\":\"tempLimit\",\"data\":\"1\",\"state\":0,\n{\"name\":\"heatEff\",\"data\":\"0.00\",\"state\":2}]}";
Map<String, Double> map = new HashMap<>();

int index0 = 0, index1, index2;

while (true) {
    // Get indices
    index0 = string.indexOf("name", index0);
    index1 = string.indexOf("data", index0);
    index2 = string.indexOf("state", index1);

    // If "name", "data", or "state" was not found
    if (index0 == -1 || index1 == -1 || index2 == -1)
        break;

    // Get the data from the string and put it into the map
    String key = string.substring(index0 + 7, index1 - 3);
    Double value = Double.parseDouble(string.substring(index1 + 7, index2 - 3));
    map.put(key, value);

    // Update index
    index0 = index2;
}

System.out.println(map);