Scanner scanner=new Scanner(System.in);
System.out.println("Enter test 1 value");
// initial value is created and passed in to test method here
double test1 = Double.parseDouble(scanner.nextLine());
// here we grab the return value of the test method
double value1 = test(test1);
System.out.println("Enter test 2 value");
// initial value is created and passed in to tests method here
double test2 = Double.parseDouble(scanner.nextLine());
// here we grab the return value of the tests method.
double value2 = tests(test2);
// pass in the value returned from both methods (ensuring we have the latest user input) to display
display(value1, value2);