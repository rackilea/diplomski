@Override
public Stream<Map<String, Object>> find(Map<String, Object> query, Map<String, Object> project, Map<String, Object> sort, Map<String, Object> pagination) {
    FindIterable<Document> documents = query == null ? collection.find() : collection.find(new Document(query));
    if (project != null) documents = documents.projection(new Document(project));
    if (sort != null) documents = documents.sort(new Document(sort));
    if (pagination != null) {
        Object skip = pagination.get("skip");
        Object limit = pagination.get("limit");
        if (skip != null) documents = documents.skip(Integer.parseInt(String.valueOf(skip)));
        if (limit != null) documents = documents.limit(Integer.parseInt(String.valueOf(limit)));
    }
    return asStream(documents);
}