public interface Page<T> extends Slice<T> {

    /**
     * Returns the number of total pages.
     * 
     * @return the number of total pages
     */
    int getTotalPages();

    /**
     * Returns the total amount of elements.
     * 
     * @return the total amount of elements
     */
    long getTotalElements();

    /**
     * Returns a new {@link Page} with the content of the current one mapped by the given {@link Converter}.
     * 
     * @param converter must not be {@literal null}.
     * @return a new {@link Page} with the content of the current one mapped by the given {@link Converter}.
     * @since 1.10
     */
    <S> Page<S> map(Converter<? super T, ? extends S> converter);
}