/**
 * The default minimum amount of memory a message is assumed to use
 */
public static final int DEFAULT_MINIMUM_MESSAGE_SIZE = 1024;

//Omitted other stuff...

@Override
public int getSize() {
    int minimumMessageSize = getMinimumMessageSize();
    if (size < minimumMessageSize || size == 0) {
        size = minimumMessageSize;
        if (marshalledProperties != null) {
            size += marshalledProperties.getLength();
        }
        if (content != null) {
            size += content.getLength();
        }
    }
    return size;
}

protected int getMinimumMessageSize() {
    int result = DEFAULT_MINIMUM_MESSAGE_SIZE;
    //let destination override
    MessageDestination dest = regionDestination;
    if (dest != null) {
        result=dest.getMinimumMessageSize();
    }
    return result;
}