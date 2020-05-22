/**
 * This class contains all the client-server errors--those errors that must be sent from the server to the client. These
 * are thus part of the protocol. The names can be changed but the error code cannot.
 *
 * Note that client library will convert an unknown error code to the non-retriable UnknownServerException if the client library
 * version is old and does not recognize the newly-added error code. Therefore when a new server-side error is added,
 * we may need extra logic to convert the new error code to another existing error code before sending the response back to
 * the client if the request version suggests that the client may not recognize the new error code.
 *
 * Do not add exceptions that occur only on the client or only on the server here.
 */
public enum Errors {
    UNKNOWN_SERVER_ERROR(-1, "The server experienced an unexpected error when processing the request.",
            UnknownServerException::new),
    NONE(0, null, message -> null),
    OFFSET_OUT_OF_RANGE(1, "The requested offset is not within the range of offsets maintained by the server.",
            OffsetOutOfRangeException::new),
    CORRUPT_MESSAGE(2, "This message has failed its CRC checksum, exceeds the valid size, has a null key for a compacted topic, or is otherwise corrupt.",
            CorruptRecordException::new),
    UNKNOWN_TOPIC_OR_PARTITION(3, "This server does not host this topic-partition.",
            UnknownTopicOrPartitionException::new),
    INVALID_FETCH_SIZE(4, "The requested fetch size is invalid.",
            InvalidFetchSizeException::new),
    LEADER_NOT_AVAILABLE(5, "There is no leader for this topic-partition as we are in the middle of a leadership election.",
            LeaderNotAvailableException::new),
...