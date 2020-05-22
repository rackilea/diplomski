public class CardinalityException extends RuntimeException {
  ...
}

public interface Values<T> extends Collection<T> {

  /**
   * @return the equivalent of iterator().next() if size() == 1
   * @throws CardinalityException if collection is empty 
   *         or contains more than one element.
   */
  T unique() throws CardinalityException;

  /**
   * @return one element from the collection, or null if empty
   */
  T one();
}