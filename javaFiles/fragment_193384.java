List<ParseObject> objects // this has already objects;

final Map<String, ArrayList<ParseObject>> categoryTopics = new LinkedHashMap<>();
for (final ParseObject object : objects) {

    final String category = object.getParseObject("helpCategory").fetchIfNeeded().getString("name");
    if (categoryTopics.containsKey(category)) {
        final ArrayList<ParseObject> topics = categoryTopics.get(category);
        topics.add(object);
        categoryTopics.put(category, topics);
    } else {
        final ArrayList<ParseObject> topics = new ArrayList<>();
        topics.add(object);
        categoryTopics.put(category, topics);
    }
}