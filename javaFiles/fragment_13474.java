* @param keyMapper a mapping function to produce keys
 * @param valueMapper a mapping function to produce values
 * @param mergeFunction a merge function, used to resolve collisions between
 *                      values associated with the same key, as supplied
 *                      to {@link Map#merge(Object, Object, BiFunction)}
 * @param mapSupplier a function which returns a new, empty {@code Map} into
 *                    which the results will be inserted