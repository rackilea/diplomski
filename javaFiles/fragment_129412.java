public static Integer valueOf(int i) {
         final int offset = 128;
         if (i >= -128 && i <= 127) { // must cache
             return IntegerCache.cache[i + offset];
         }
         return new Integer(i);
     }