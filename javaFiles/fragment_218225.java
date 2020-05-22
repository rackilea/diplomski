Arrays.sort(interval, new Comparator<int[]>() {
     @Override
     public int compare(int[] o1, int[] o2) {
         int result = Integer.compare(o1[0], o2[0]);
         if (result == 0) {
             result = Integer.compare(o2[1], o1[1]);
         }
         return result;
     }
 });