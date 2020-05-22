HashMap<String, List<String>> myMap = new HashMap<>();

    try {
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("#")) {
                String[] parts = string.split(delimiter);
                String key     = parts[0];
                String value   = parts[1];
                if (myMap.containsKey(key)) {
                    myMap.get(key).add(value);
                } else {
                    List<String> values = new ArrayList<String>();
                    values.add(value);
                    myMap.put(key, values);
                }
            }
        }