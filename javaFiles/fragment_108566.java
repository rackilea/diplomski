private static List<String> removeTopic(List<String> topics, String topic) {
    List<String> topicsCopy = new ArrayList<>(topics);
    topicsCopy.remove(topic);
    topicsCopy.add(null);
    return topicsCopy;
}