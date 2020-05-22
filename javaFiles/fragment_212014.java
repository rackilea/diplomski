import java.util.HashMap;
import java.util.Map;

public class MessageType {
    private final static Map<Long, MessageType> messageTypes = new HashMap<>();

    // it isn't clear how the libraries would provide information on
    // the message types they support; suppose that each library has a
    // MessageInfo that implements Map<Long, String> with all its types:
    public static void loadLibrary(MessageInfo messageInfo) {
        // populate the map with each message type it supports
        for (Map.Entry<Long, String> entry : messageInfo.entrySet()) {
            MessageType messageType =
                new MessageType(entry.getKey(), entry.getValue());
            messageTypes.put(entry.getKey(), messageType);
        }
    }

    // A MessageType has a name and a number
    private final long number;
    private final String name;

    private MessageType(long number, String name) {
        this.number = number;
        this.name = name;
    }

    public long getMessageNumber() {
        return number;
    }

    public String getMessageName() {
        return name;
    }

    public static MessageType fromMessageNumber(long number) {
        if (!messageTypes.containsKey(number)) {
            throw new IllegalArgumentException("Unknown message: " + number);
        }
        return messageTypes.get(number);
    }
}