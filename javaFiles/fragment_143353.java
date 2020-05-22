public static int binarySearch(final List<Integer> arr, final int l, final int r, final Integer x)
{
   if (r >= l)
   {
      final int mid = l + (r - l) / 2;

      // If the element is present at the middle itself
      if (x.equals(arr.get(mid)))
         return mid;

      // If element is smaller than mid, then it can only
      // be present in left subarray
      if (arr.get(mid) > x)
         return binarySearch(arr, l, mid - 1, x);

      // Else the element can only be present in right
      // subarray
      return binarySearch(arr, mid + 1, r, x);
   }
   // We reach here when element is not present in array
   return -1;
}