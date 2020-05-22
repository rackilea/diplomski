class NodeWalker {

    private final JSONObject object;

    public NodeWalker(JSONObject object) {
        this.object = object;
    }

    public List<String> findContentFor(String name) {
        LinkedList<JSONObject> queue = new LinkedList<>();
        queue.add(object);
        while (queue.size() > 0) {
            JSONObject next = queue.pop();
            Object fileName = next.get("name");
            final String contentName = "content";
            if (fileName != null && fileName.equals(name) && next.has(contentName)) {
                JSONArray content = next.getJSONArray(contentName);
                if (content == null) {
                    return Collections.emptyList();
                }
                List<String> result = new ArrayList<>();
                IntStream.range(0, content.length()).forEach(i -> result.add(content.getString(i)));
                return result;
            }
            final String childrenName = "children";
            if (next.has(childrenName)) {
                JSONArray array = next.getJSONArray(childrenName);
                IntStream.range(0, array.length()).forEach(i -> queue.add(array.getJSONObject(i)));
            }
        }

        return Collections.emptyList();
    }
}