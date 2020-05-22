public final class String implements ... {
    ...
    /** Cache the hash code for the string */
    private int hash; // Default to 0

    ...

    public int hashCode() {
        int h = hash;
        if (h == 0 && ...) {
            ...
            hash = h;
        }
        return h;
    }

    ...
}