public static String toFormattedString(char[] a)
 {
    switch (a.length)
      {case 0 : return "";    
       case 1 : return String.valueOf(a[0]);
       default: return a[0]+toFormattedString(Arrays.copyOfRange(a,1,a.length));
      }
}