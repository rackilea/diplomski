String json = Files.lines(Paths.get("src/main/resources/data.json")).collect(Collectors.joining());

JSONObject jsonObject = new JSONObject(json);
JSONArray phoneNumbers = jsonObject.getJSONArray("phoneNumbers");

String homeNumber = phoneNumbers.toList()
            .stream()
            .map(o -> (Map<String, String>) o)
            .filter(stringStringMap -> stringStringMap.get("type").equals("home"))
            .map(stringStringMap-> stringStringMap.get("number"))
            .findFirst()
            .orElse("unknown");

System.out.println(homeNumber);