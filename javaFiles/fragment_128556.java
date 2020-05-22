Map<String, Integer> topicIndex = new HashMap<>();
List<String> topicList = new ArrayList<>();  // topicList is used to print the matrix
int index = 0;
for (String topic : postingList.keySet()) {
    if (!topicIndex.containsKey(topic)) {
        topicIndex.put(topic, index++);
        topicList.add(topic);
    }
}