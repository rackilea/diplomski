int numberOfZeroes(int[] a, int right) {
  if(right < 0) {  // We've gone through all indices
    return 0;  // So we don't want to recurse anymore
  } else if(a[right] == 0) {  // The current index has a zero
    return 1 + numberOfZeroes(a, right - 1); // Call the function, moving left one. Add one to the returned count since we found a zero
  } else {  // The current index does not have a zero
    return numberOfZeroes(a, right - 1); // Call the function, moving left one. We don't add anything since we didn't find a zero
  }
}