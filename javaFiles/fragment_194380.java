for (int index = 1; index < A.size(); index += 2) { // Swap on even indices.
   // Swap values at positions index-1 and index.
   Object temp = A.get(index-1); // Save value before overwrite.
   A.set(index-1, A.get(index)); // First half of swap.
   A.set(index, temp); // Final operation for swap.
}