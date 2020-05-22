String s = "(10, 10)";

Scanner sc = new Scanner(s);
sc.useDelimiter("[(), ]+");

int x=sc.nextInt();
int y = sc.nextInt();

System.out.println("x="+x);
System.out.println("y="+y);