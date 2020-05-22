public static String toFormattedString(char[] a)
{
     if (a.length==1) return String.valueOf(a[0]);
     else     
     return a[0]+toFormattedString(Arrays.copyOfRange(a,1,a.length)) ;

}