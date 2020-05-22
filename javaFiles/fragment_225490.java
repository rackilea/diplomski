public static int[] unique (int[] n){
 boolean[] seen = new boolean[n.length];
 int[] unique = new int[n.length];
 Random rand = new Random(123L);
 for (int i = 0; i < n.length; i++)
 {
     int index = rand.nextInt(n.length);
     while (seen[index])
     {
         index = rand.nextInt(n.length);
     }
     seen[index] = true; //boolean array updated
     unique[i] = n[index];
 }
 return unique;