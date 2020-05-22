public class Message {
    private final Map<String, String> mProperties;

    public Message() {
        mProperties = new HashMap<>();
    }

    public String getValue(String key) {
        return mProperties.get(key);
    }

    public void put(String key, String value) {
        mProperties.put(key, value);
    }

    public static Message fromLines(List<String> lines) {
        Message message = new Message();
        for (String line : lines) {
            String[] data = line.split(":");
            message.put(data[0].trim(), data[1].trim());
        }
        return message;
    }

    // Other methods ...
}