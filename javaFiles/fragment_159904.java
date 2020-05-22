public static int BinarySearch(int[] A, int x) {
      int low = 0;
      int high = A.length - 1;
      int mid = -1;
      while (low <= high) {
        mid = low + (high-low)/2;
        if (x <= A[mid]) { // this ensures you keep searching for the first index having
                           // the number you are looking for
                           //
                           // changing x <= A[mid] to x < A[mid] will give you the
                           // last index having the number you are looking for instead
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      if (mid >= 0 && x == A[mid]) {
        return mid;
      }
      return -1;
    }