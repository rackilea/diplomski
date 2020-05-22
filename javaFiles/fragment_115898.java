json = new JsonSerializer().excludeNulls(true).onValue(value -> {
        if (value instanceof Map) {
            if (((Map)value).isEmpty()) {
                return new EmptyJsonSerializer();
            }
        }
        return null;
    }).serialize(map);