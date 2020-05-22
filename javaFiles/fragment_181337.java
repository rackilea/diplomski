/**
 * Extension of a {@link ExceptionMapper exception mapper interface}. The exception mapping
 * providers can extend from this interface to add jersey specific functionality to these
 * providers.
 *
 * @author Miroslav Fuksa
 *
 * @param <T> A type of the exception processed by the exception mapper.
 */
public interface ExtendedExceptionMapper<T extends Throwable> extends ExceptionMapper<T> {
    /**
     * Determine whether this provider is able to process a supplied exception instance.
     * <p>
     * This method is called only on those exception mapping providers that are able to
     * process the type of the {@code exception} as defined by the JAX-RS
     * {@link ExceptionMapper} contract. By returning {@code false} this method can reject
     * any given exception instance and change the default JAX-RS exception mapper
     * selection behaviour.
     * </p>
     *
     * @param exception exception instance which should be processed.
     * @return {@code true} if the mapper is able to map the particular exception instance,
     *         {@code false} otherwise.
     */
    public boolean isMappable(T exception);
}