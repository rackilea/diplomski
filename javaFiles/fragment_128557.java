index = 0;
Map<String, Integer> documentIndex = new HashMap<>();
for (String topic : postingList.keySet()) {
    for (String document : postingList.get(topic).keySet()) {
        if (!documentIndex.containsKey(document))
            documentIndex.put(document, index++);
    }
}