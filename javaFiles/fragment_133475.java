public default GraphTraversal<S, Vertex> person(String personId, String name) {
    if (null == personId || personId.isEmpty()) throw new IllegalArgumentException("The personId must not be null or empty");
    if (null == name || name.isEmpty()) throw new IllegalArgumentException("The name of the person must not be null or empty");

    return coalesce(__.V().has(VERTEX_PERSON, KEY_PERSON_ID, personId),
                    __.addV(VERTEX_PERSON).property(KEY_PERSON_ID, personId)).
            property(KEY_NAME, name);
}