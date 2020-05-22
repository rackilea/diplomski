Collections.sort(stuff, new Comparator<Map.Entry<String, Person>>() {
    @Override
    public int compare(Map.Entry<String, Person> entry1, Map.Entry<String, Person> entry2) {
        return Integer.compare(entry1.getValue().getOrder(), entry2.getValue().getOrder());
    }
});