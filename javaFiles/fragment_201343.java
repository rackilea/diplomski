Comparator<HashMap<String, String>> comparator = new Comparator<HashMap<String, String>>() {
    @Override
    public int compare(HashMap<String, String> map1, HashMap<String, String> map2) {
        return map1.get(KEY_COST).compareTo(map2.get(KEY_COST));
    }
};