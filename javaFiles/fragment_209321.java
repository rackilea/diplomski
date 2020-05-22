public static int[] StringArrToIntArr(String[] s) {
   int[] result = new int[s.length];
   for (int i = 0; i < s.length; i++) {
      result[i] = Integer.parseInt(s[i]);
   }
   return result;
}