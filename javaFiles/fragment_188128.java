public static void main(String[] args){
int[] n= new int[8];
n[0]=3;
n[6]=2;
n[1]=5;
n[3]=20;
quicksort(n, 0, n.length);
for (int i=0; i<n.length; i++){
    System.out.print(n[i]+",");
}
}