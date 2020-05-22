public static void main(String[] args) throws IOException, TransformationException {
    Map<String, Map<String, Integer>> actions = new HashMap<String, Map<String, Integer>>();
    Genson genson = new Genson();

    ObjectReader reader = genson.createReader(new FileReader("path/to/the/file"));
    while(reader.hasNext()) {
        reader.next();
        reader.beginObject();
        String action = readUntil("action", reader);
        // assuming the next name/value pair is responsecode
        reader.next();
        String responseCode = reader.valueAsString();
        Map<String, Integer> countMap = actions.get(action);
        if (countMap == null) {
            countMap = new HashMap<String, Integer>();
            actions.put(action, countMap);
        }

        Integer count = countMap.get(responseCode);
        if (count == null) {
            count = 0;
        }
        count++;
        countMap.put(responseCode, count);

        reader.endObject();
    }

    // for example if you had 2 different response codes for same action it will print
    // {"Some_Action":{"1001":1,"1000":1}}
    String json = genson.serialize(actions);
}

static String readUntil(String name, ObjectReader reader) throws IOException {
    while(reader.hasNext()) {
        reader.next();
        if (name.equals(reader.name())) {
            return reader.valueAsString();
        }
    }
    throw new IllegalStateException();
}