public List<String> filter(String[] filePaths, JsonObject rules) throws FileNotFoundException {
        final List<String> filtered = new ArrayList<String>();
        final Set<Map.Entry<String, JsonElement>> rulesEntries = rules.entrySet();
        for (String path : filePaths) {
            final Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            final JsonObject file = jsonParser.parse(reader).getAsJsonObject();
            final Set<Map.Entry<String, JsonElement>> fileEntries = file.entrySet();
            if (fileEntries.containsAll(rulesEntries)) filtered.add(path);
        }
        return filtered;
    }