/** Add or replace value. */
public Result<T> put(final String key, final T value) {
    Map<T> copy = new LinkedHashMap<>(result);
    copy.put(key, value);
    return new Result<>(copy);
}