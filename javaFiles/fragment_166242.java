for (Entry<String,JsonElement> j : locations) {
            JsonObject location = (JsonObject) j.getValue();
            JsonObject coordinate = (JsonObject) location.get("coordinates");
            JsonObject address = (JsonObject) location.get("address");
            System.out.println(location.get("location_id"));
            System.out.println(location.get("store_name"));
            System.out.println(coordinate.get("latitude"));
            System.out.println(coordinate.get("longitude"));
            System.out.println(address.get("street_number"));
            System.out.println(address.get("street_name"));
            System.out.println(address.get("suburb"));
        }