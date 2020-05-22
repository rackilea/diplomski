package example;

/**
 * @see java.awt.EventDispatchThread#handleException(Throwable thrown)
 */
public interface AwtExceptionHandler {
    void handle(Throwable t) throws Throwable;
}