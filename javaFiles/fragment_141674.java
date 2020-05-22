//The comparator now has to be defined outside Arrays.sort()
//or else the variable i is final and cannot be changed
public static Comparator<int[]> createComparator(int i){
    return new Comparator<int[]>() {
    @Override
      public int compare(int[] o1, int[] o2) {
       return Integer.compare(o1[i], o2[i]);
      }
    };
}

public static int[][] sortMatrix(int[][] m){
    for (int i=m[0].length-1; i>=0; i--){
        Arrays.sort(m, createComparator(i)); 
    }       
    return(m);
}