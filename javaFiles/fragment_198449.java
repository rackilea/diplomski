int num;
  double num2;
  String name;
  char c;

  Scanner sc = new Scanner(System.in);

  //for integer
  System.out.print("Enter a number: ");
  num = sc.nextInt();
  System.out.printf("%d\n", num);

  //for float
  System.out.print("Enter a float value: ");
  num2 = sc.nextDouble();
  System.out.printf("%.2f\n", num2);

  //for name w/o white space
  System.out.print("Enter your first name: ");
  name = sc.next();
  System.out.printf("Hello %s, welcome to Scanner\n", name);

  //for character
  System.out.print("Enter a character: ");
  c = sc.findWithinHorizon(".", 0).charAt(0);
  System.out.printf("%c\n", c);

  sc.nextLine(); // skip

  //for name w/ white space
  System.out.print("Enter your full name: ");
  name = sc.nextLine();
  System.out.printf("%s", name);