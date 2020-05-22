public static void main(String[] args) {
    int x = 2, y = 4, z = 0, q = 0;
    while (z < y) {
        while (z < x) {
            System.out.print(z + " ");
            z++;
         }
         if(q == 0){
            z = 0;
            q++;
        }
        System.out.print(z + " ");
        z++;
    }
    System.out.print(z + " ");
}