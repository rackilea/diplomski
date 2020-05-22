try {
   connection = ...;
   try {
      statement = ...;
   } finally {
      // Clean up statement
   }
} finally {
   // Clean up connection
}