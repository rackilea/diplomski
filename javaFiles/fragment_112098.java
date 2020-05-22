/**
 * Gets the request payload as byte array.
 *
 * @return the request payload
 */
public byte[] getRequestPayload() {
    return exchange.getRequest().getPayload();
}