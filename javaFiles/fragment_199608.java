/**
 * Turns an {@code AccessLevel} instance into the flag bit used by javac.
 */
public static int toJavacModifier(AccessLevel accessLevel) {
    switch (accessLevel) {
    case MODULE:
    case PACKAGE:
        return 0;
    default:
    case PUBLIC:
        return Flags.PUBLIC;
    case NONE:
    case PRIVATE:
        return Flags.PRIVATE;
    case PROTECTED:
        return Flags.PROTECTED;
    }
}