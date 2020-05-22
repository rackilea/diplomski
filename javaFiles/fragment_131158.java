/**
 * Construct an instance with the provided target type, and
 * useHeadersIfPresent with a default {@link ObjectMapper}.
 * @param targetType the target type.
 * @param useHeadersIfPresent true to use headers if present and fall back to target
 * type if not.
 * @since 2.2
 */
public JsonDeserializer(Class<? super T> targetType, boolean useHeadersIfPresent) {