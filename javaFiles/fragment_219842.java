@Override
public boolean equals(Object other) {
    // Check that other is even an AList
    if (!(other instanceof AList)) {
        return false;
    }

    // If it is, cast it and compare the contents:
    AList otherAList = (AList) other;

    // Compare the lenghts of the arrays
    if (this.numberOfEntires != otherAList.numberOfEntries) {
        return false;
    }

    // Compare the contents of the arrays:
    for (int i = 0; i < this.numberOfEntries; ++i) {
        if (!this.list[i].equals(otherAList.list[i])) {
            return false;
        }
    }

    // Didn't find a reason why the two aren't equal, so they must be:
    return true;
}