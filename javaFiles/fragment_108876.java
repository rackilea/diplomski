public static void recursivePrintHierarchy(String prefix, int depth) {
      __recursivePrintHierarchy(prefix, depth - 1, depth);
   }

   private static void __recursivePrintHierarchy(String prefix, int depth, int limit) {
      if (depth < 0) {
         return;
      }
      for (int i = 1; i <= limit; i++) {
         String result = prefix + i;
         System.out.println(result);
         __recursivePrintHierarchy(result + "-", depth - 1, limit);
      }
   }