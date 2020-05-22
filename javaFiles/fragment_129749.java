Scanner scanner = new Scanner(System.in);
boolean p = scanner.nextInt() != 0;
boolean q = scanner.nextInt() != 0;
boolean r1 = p && q;
boolean r2 = q == r1;
boolean r3 = p == r2;
System.out.println(r3 ? 1 : 0);