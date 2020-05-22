Scanner sc = new Scanner(System.in);
System.out.println("Enter a: ");
int a = sc.nextInt();
int b;
do {
    System.out.println("Enter b: ");
    b = sc.nextInt();
} while (b == a);

for (int i=Math.min(a, b); i <= Math.max(a,b); ++i) {
    System.out.println(i);
}