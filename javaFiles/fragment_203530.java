JSONObject json = getJsonFromFile(filePath);
HashMap<String, Number> entries = new HashMap<>();

for (Object obj : json.entrySet()) {
    Entry<String, Number> mapEntry = (Entry<String, Number>) obj;
    System.out.println("key: " + mapEntry.getKey() + " value: " + mapEntry.getValue());
    entries.put(mapEntry.getKey(), mapEntry.getValue());
}