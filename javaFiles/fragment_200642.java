Scanner scan = new Scanner(System.in);

System.out.print("Enter Value For x: ");
int x = scan.nextInt();

System.out.print("Enter Value For y: ");
int y = scan.nextInt();

System.out.print("Enter Value For z: ");
int z = scan.nextInt();

int max = Math.max(Math.max(x, y), z);
System.out.println("The Maximum is " + max);