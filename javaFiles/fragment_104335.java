@Override
public String toString() {
   StringBuilder sb = new StringBuilder("[");
   for (int h = 0; h < array.length; h++) {
      sb.append(array[h]);
      if (h != array.length - 1) {
         sb.append(", ");
      }
   }
   sb.append("]");
   return sb.toString();
}