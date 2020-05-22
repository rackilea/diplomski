public static List<String> replace(Collection<String> attributes, String value, Collection<String> additionalValues) {
    List<String> res = new LinkedList<>();

    for (String attribute : attributes) {
        if (value.equals(attribute))
            res.addAll(additionalValues);
        else
            res.add(attribute);
    }

    return res;
}