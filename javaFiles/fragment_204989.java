class Node {

    Integer id;
    Map<String, Integer> interestPreferences;

    public Node(Integer id) {
        this.id = id;
        this.interestPreferences = new HashMap<String, Integer>();
    }

    void setPreference(String key, Integer value) {
        interestPreferences.put(key, value);
    }

    Interest getPreference(String key) {
        return interestPreferences.get(key);
    }
}