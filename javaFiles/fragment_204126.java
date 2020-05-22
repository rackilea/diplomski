public List<List<DataPost>> sortAndGroup(Collection<DataPost> posts) {
    Map<String, List<DataPost>> groups = new TreeMap<>();
    for (DataPost post : posts) {
        String id = post.getIds_post();
        List<DataPost> list = groups.get(id);
        if (list == null) {
            list = new ArrayList<>();
            groups.put(id, list);
        }
        list.add(post);
    }
    return new ArrayList<>(groups.values());
}