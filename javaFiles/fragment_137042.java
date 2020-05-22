public class ArraySegment {
    protected int[] array;
    protected int boundLo;
    protected int boundHi;

    public class ArraySegment (int[] array) {
        // entire array.
        this( array, 0, array.length);
    }
    public class ArraySegment (int[] array, int lo, int hi) {
        this.array = array;
        this.boundLo = lo;
        this.boundHi = hi;
    }

    public int binarySearch (int target) {
        if (boundHi <= boundLo) {
            return -1;         // Empty;  not found.
        }

        int pivot = (boundLo + boundHi) / 2;
        int pivotEl = array[ pivot];
        if (target == pivotEl) {
            return pivot;      // Found!
        }
        if (target < pivotEl) {
            // recurse Left of pivot.
            ArraySegment sub = new ArraySegment( array, boundLo, pivot);
            return sub.binarySearch( target);
        } else {
            // recurse Right of pivot.
            ArraySegment sub = new ArraySegment( array, pivot, boundHi);
            return sub.binarySearch( target);
        }
    }
}