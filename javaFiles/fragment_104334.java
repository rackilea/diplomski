@Override
public String toString() {
   String s = "[";
   for (int h = 0; h < array.length; h++) {
      s += array[h];
      if (h != array.length - 1) {
         s += ", ";
      }
   }
   s += "]";
   return s;
}