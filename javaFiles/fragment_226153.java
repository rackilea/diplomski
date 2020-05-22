public static HashSet<Integer> mode(int[] num){
    HashSet<Integer> dup = new HashSet<>();
    for(int x=0; x < num.length; x++) {
       for(int y=0; y < num.length; y++) {
          if(num[x] == num[y] && x != y) {
              dup.add(num[x]); 
          }
       }
    }
    return dup;
}