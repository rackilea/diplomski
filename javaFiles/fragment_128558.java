int[][] mat = new int[topicIndex.size()][documentIndex.size()];
for (String topic : postingList.keySet()) {
    for (String document : postingList.get(topic).keySet()) {
        mat[topicIndex.get(topic)][documentIndex.get(document)] = postingList.get(topic).get(document);
    }
}