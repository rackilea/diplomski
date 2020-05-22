/**
 * Coerce a Matcher instance to a boolean value.
 *
 * @param matcher the matcher
 * @return the boolean value
 * @since 1.7.0
 */
public static boolean asBoolean(Matcher matcher) {
    if (null == matcher) {
        return false;
    }

    RegexSupport.setLastMatcher(matcher);
    return matcher.find();
}