public interface MessageType {    
    public static final class HELLO implements MessageType {};
}

public interface Message<T extends MessageType> {
    Class<T> getTypeClass();
}

public interface Response<T extends MessageType> {
}