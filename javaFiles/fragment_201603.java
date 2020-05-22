/**
 * Sets the general request property. If a property with the key already
 * exists, overwrite its value with the new value.
 * ...
 */
public void setRequestProperty(String key, String value) {
    if (connected)
        throw new IllegalStateException("Already connected");
    if (key == null)
        throw new NullPointerException ("key is null");

    if (requests == null)
        requests = new MessageHeader();

    requests.set(key, value);
}