/**
 * Node class that matches a POSIX type.
 */
static final class Ctype extends BmpCharProperty {
    final int ctype;
    Ctype(int ctype) { this.ctype = ctype; }
    boolean isSatisfiedBy(int ch) {
        return ch < 128 && ASCII.isType(ch, ctype);
    }
}