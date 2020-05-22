static JSONObject convert(JSONObject initial) {
        // STATE -> CITY -> Address[]
        Map<String, Map<String, List<Map<String, Object>>>> stateToCityToAddresses = new HashMap<>();

        // Get list of codes
        String[] codes = JSONObject.getNames(initial);

        // Loop over codes - "600450", "600451", "600453", ...
        for (String code : codes) {

            // Get the JSONObject containing state data
            JSONObject state = initial.getJSONObject(code);

            // Extract information from state JSONObject
            String stateName = state.getString("STATE");
            String cityName = state.getString("CITY");
            long id = state.getLong("ID");
            long contact = state.getLong("CONTACT");

            // Some Java 8 awesomeness!
            List<Map<String, Object>> addresses = stateToCityToAddresses
                .computeIfAbsent(stateName, sn -> new HashMap<>()) // This makes sure that there is a Map available to hold cities for a given state
                .computeIfAbsent(cityName, cn -> new ArrayList<>()); // This makes sure that there is a List available to hold addresses for a given city

            // Save data in a map representing a json object like: {"CONTACT":1234,"CODE":600450,"ID":1}
            Map<String, Object> address = new HashMap<>();
            address.put("ID", id);
            address.put("CONTACT", contact);
            address.put("CODE", Long.parseLong(code));

            // Add the address under city
            addresses.add(address);
        }

        // Just use the JSONObject.JSONObject(Map<?, ?>) constructor to get the final result
        JSONObject result = new JSONObject(stateToCityToAddresses);

        // You can sysout the result to see the data
        // System.out.println(result);

        return result;
    }