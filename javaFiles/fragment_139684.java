static void learnFromText(Map<List<String> whatComesNext, List<String>, List<String> text) {
    for (int i=0; i<= text.size() - 3; i++) {
        List<String> listKey = text.subList(i, i+2);
        List<String> value = whatComesNext.get(listKey);
        if (value == null) {
            value = new ArrayList<>();
            whatComesNext.put(listKey, value);
        }

        value.add(text.get(i+2)));
    }
}