/**
 * Whether to use suffix pattern match (".*") when matching patterns to
 * requests. If enabled a method mapped to "/users" also matches to "/users.*".
 * <p>The default value is {@code true}.
 * <p>Also see {@link #setUseRegisteredSuffixPatternMatch(boolean)} for
 * more fine-grained control over specific suffixes to allow.
 */
public void setUseSuffixPatternMatch(boolean useSuffixPatternMatch) {