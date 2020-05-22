* A byte array (de)serializer that does nothing with the payload; sends it raw.
 * Message termination for assembly purposes is signaled by the client closing the
 * connection. The serializer does not, itself, close the connection after
 * writing the bytes.
 * <p>
 * Because the socket must be closed to indicate message end, this (de)serializer
 * can only be used by uni-directional (non-collaborating) channel adapters, and
 * not by gateways.