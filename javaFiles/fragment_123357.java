int[][] rgb = {{1, 2}, {3, 4}};
int[] result = {0, 1};

for (int[] arr : rgb)
    for (int n = 0; n < arr.length; n++)
        arr[n] = result[n] == 0 ?
                 (arr[n] & ~1) /* clear */ : 
                 (arr[n] | 1) /* set */;


for (int[] arr : rgb) {
    String sep = "";
    for(int i : arr) {
        System.out.print(sep + Integer.toBinaryString(i));    
        sep = ", ";
    }
    System.out.println();
}