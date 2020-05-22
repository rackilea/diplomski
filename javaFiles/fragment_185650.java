public MultivaluedMap<String, Object> getMetadata() {
    if (headers != null)
        return headers;

    headers = new OutBoundHeaders();

    for (int i = 0; i < values.length; i++)
        if (values[i] != null)
            headers.putSingle(ResponseBuilderHeaders.getNameFromId(i), values[i]);

    Iterator i = nameValuePairs.iterator();
    while (i.hasNext()) {
        headers.add((String)i.next(), i.next());
    }

    return headers;
}