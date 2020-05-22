/**
 * Because of erasure, at compile time the injector can only guarantee that it
 * returns something that extends Communication, not necessarily C. The cast and
 * @SuppressWarnings will help with that.
 */
@SuppressWarnings("unchecked")
public static <C extends Communication> Provider<C> getCommunicationProvider(
    C communication) {
  return (Provider<C>) injector.getProvider(Key.get(communication.getClass(),
      Names.named(communication.toString())));
}