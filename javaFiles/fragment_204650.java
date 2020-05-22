/**
 * CLOSE Command.
 *
 * @see "RFC2060, section 6.4.2"
 */
public void close() throws ProtocolException {
   simpleCommand("CLOSE", null);
}