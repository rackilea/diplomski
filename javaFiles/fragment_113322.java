Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int r = n;

for (int i=1; i <= r; i++) {
    for (int j=n-1; j >= 1; j--) {
        System.out.print(" ");
    }
    n--;
    for (int k=1; k<= i;k++) {
        System.out.print(" *");
    }
    System.out.println();
}