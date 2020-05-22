public static List<String> combine(List<String[]> list) {
    List<String> elements = new ArrayList<String>();
    if (!list.isEmpty()) {
        String[] head = list.get(0);
        List<String> tail;
        if (list.size() > 1) {
            tail = combine(list.subList(1, list.size()));
        } else {
            tail = Arrays.asList("");
        }
        for (String headElem : head) {
            for (String tailElem : tail) {
                elements.add(headElem + tailElem);
            }
        }
    }
    return elements;
}