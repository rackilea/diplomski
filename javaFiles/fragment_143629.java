public enum Messages {

    MESSAGE_1("Message", "Category"),
    MESSAGE_2("Another Message", "Category"),
    MESSAGE_3("Odd Message", "Another Category");

    private static final Map<String, Set<String>> map = new HashMap<>();
    static {
        for (Messages m : Messages.values()) {
            map.computeIfAbsent(m.category, s -> new HashSet<>()).add(m.message);
        }
    }

    private final String message, category;

    private Messages(String message, String category) {
        this.message = message;
        this.category = category;
    }

    public String getMessage() { return message; }
    public String getCategory() { return category; }

    public static boolean isMessageInGroup(String message){
        // use `getOrDefault` if `get` could return null!!
        return map.get("Category").contains(message);
    }
}