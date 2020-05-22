Scanner scan = new Scanner(System.in);
int num = scan.nextInt();


for (int i = 1; i < num; i++) {
    System.out.printf("%d\t", i);
}
System.out.println();
for (int i1 = 1; i1 < num; i1++) {
     for (int j = 1; j <= i1; j++) {
          System.out.printf("%d\t", i1 * j);
     }
     System.out.println();
}