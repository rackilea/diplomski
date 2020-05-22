private static class CloneableObject
        implements
            Cloneable {

    @Override
    public CloneableObject clone() {
        return new CloneableObject();
    }
}


CloneableObject[][] original;


void someMethod() {
    CloneableObject[][] copy = Arrays.copyOf(this.original, this.original.length);
    for (int i = 0; i < copy.length; i++) {
        copy[i] = Arrays.copyOf(copy[i], copy[i].length);
        for (int j = 0; j < copy[i].length; j++) {
            copy[i][j] = copy[i][j].clone();
        }
    }

    /*
     * Manipulation of this.original is to be done here
     * None of the manipulations will be reflected in copy
     * 
     * Note that (this.original[n][m] == copy[n][m]) will evaluate to false,
     * where n and m are arbitrary indices of the array.
     */

    this.original = copy; // "reset"
}