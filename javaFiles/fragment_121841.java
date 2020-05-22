public static String smallestOfTwo(int[] n,int[] m)
{
       Arrays.sort(n);
       Arrays.sort(m);
       for (int i = 0; i < n.length; i++) {
           if(n[i] < m[i]){
               return "Array n";
           }else if(n[i] > m[i]){
               return "Array m";
           }
       }
       return "both Array n & Array m are the same";
}