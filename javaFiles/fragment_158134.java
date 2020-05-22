public class FileBackedIntArray {
    // Index of the array in the file of arrays
    private final int index;
    private final int lastElement;

    public FileBackedIntArray(int index, int lastElement) {
        this.index = index;
        this.lastElement = lastElement;
    }

    public int getIndex() {
        return index;
    }

    public int[] readArray() {
        // Read the file and deserialize the array at the associated index
        return smth;
    }

    public int getLastElement() {
        return lastElement;
    }

    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || o.getClass() != getClass()) {
            return false;
        }

        return index == ((FileBackedIntArray) o).index;
    }
}