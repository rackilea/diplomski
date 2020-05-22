for (KVPair kvPair : content) {
    String k = kvPair.getKey();
    List<String> values = mappedContent.get(k);
    if (values == null) {
        values = new ArrayList<>();
        mappedContent.put(k, values);
    }
    values.add(kvPair.getValue());
}