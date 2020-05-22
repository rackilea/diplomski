Scanner s = new Scanner(System.in);
System.out.println("Enter the numbers of variables: ");
int i = s.nextInt();
int[][] var = new int[i][];
for(int j = 0;j < i;j++){

    System.out.println("Enter the number of values: ");
    int p = s.nextInt();
    var[j] = new int[p];
    for(int q = 0;q < p;p++){
        int n = s.nextInt();
        var[j][q] = n;
    }
}