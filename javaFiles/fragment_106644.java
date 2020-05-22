Scanner input = new Scanner(System.in);

FinalProject output = new FinalProject();

System.out.print("Enter your 1st number: ");
output.setNum1(input.nextDouble());

System.out.print("Enter your 2nd number: ");
output.setNum2(input.nextDouble());


System.out.print("The sum of two number is: " + output.getNum3());