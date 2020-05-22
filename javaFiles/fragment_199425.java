while (low <= high) {
      mid = (low + high) / 2;
      if (mid > key) {
          high = mid - 1;
      } else if (mid < key) {
          low = mid + 1;
      } else {
          return mid;
      }
}