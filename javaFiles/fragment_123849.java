public int hashCode() {
     if (hash == 0) { // (1)
         int off = offset;
         char val[] = value;
         int len = count;

         int h = 0;
         for (int i = 0; i < len; i++) {
             h = 31*h + val[off++];
         }
         hash = h;
     }
     return hash; // (2)
 }