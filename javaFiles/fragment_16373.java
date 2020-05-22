public static String parseJson(InputStream in) {
    String key = "student";
    Deque<String> stack = new LinkedList<>();
    Map<String, Object> map = new HashMap<>();
    Object obj = null;

    JsonParser parser = Json.createParser(in);

    while (parser.hasNext()) {
        Event event = parser.next();

        if (event == Event.START_OBJECT) {
            map.putIfAbsent(key, new HashMap<>());
            obj = map.get(key);
            stack.push(key);
        } else if (event == Event.END_OBJECT) {
            stack.pop();
            obj = stack.isEmpty() ? null : map.get(stack.element());
        } else if (event == Event.START_ARRAY) {
            Object tmp = new ArrayList<>();
            setValue(obj, key, tmp);
            obj = tmp;
        } else if (event == Event.END_ARRAY)
            obj = stack.isEmpty() ? null : map.get(stack.element());
        else if (event == Event.KEY_NAME)
            key = parser.getString().toLowerCase();
        else {
            Object value = null;

            if (event == Event.VALUE_STRING)
                value = parser.getString();
            else if (event == Event.VALUE_NUMBER)
                value = parser.getInt();
            else if (event == Event.VALUE_TRUE)
                value = true;
            else if (event == Event.VALUE_FALSE)
                value = false;

            setValue(obj, key, value);
        }
    }

    Student student = new Student();
    student.setName(getMapValue(map, "student", "name"));
    student.setIndex(getMapValue(map, "student", "index"));
    student.setStatus(getMapValue(map, "student", "status"));
    student.setTraditional(getMapValue(map, "student", "traditional"));
    student.setRole(getMapValue(map, "student", "role"));
    student.setPhoneNumbers(getMapValue(map, "student", "phoneNumbers"));

    Address address = new Address();
    address.setStreet(getMapValue(map, "address", "street"));
    address.setCity(getMapValue(map, "address", "city"));
    address.setZip(getMapValue(map, "address", "zip"));

    return "";
}

private static void setValue(Object obj, String key, Object value) {
    if (obj instanceof Map)
        ((Map<String, Object>)obj).put(key, value);
    else
        ((Collection<Object>)obj).add(value);
}

private static <T> T getMapValue(Map<String, Object> map, String obj, String key) {
    Map<String, Object> m = (Map<String, Object>)map.get(obj.toLowerCase());
    return m != null ? (T)m.get(key.toLowerCase()) : null;
}