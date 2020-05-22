/**
 * calculates a hashCode for this object.
 */
public int hashCode() {
    int hash = 0;
    for(int digit : digits) {
        hash = hash * 13 + digit;
    }
    return hash;
}