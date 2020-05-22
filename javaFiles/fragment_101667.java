Scanner sc = new Scanner(System.in);

System.out.print("Enter Number 1: ");
double num1 = sc.nextDouble();

System.out.print("Enter Number 2: ");
double num2 = sc.nextDouble();

BigDecimal bd1 = BigDecimal.valueOf(num1);
BigDecimal bd2 = BigDecimal.valueOf(num2);

System.out.println("Result: " + bd1.add(bd2));