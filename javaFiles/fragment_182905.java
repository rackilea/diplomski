Scanner in = new Scanner(System.in);
int test1 , test2 , test3;
double NUM_TEST= 3;
System.out.print("Input first test: "); // user prompt
test1 = in.nextInt(); // read in the next integer
System.out.print("Input second test: "); // user prompt
test2 = in.nextInt();
System.out.print("Input third test: "); // user prompt
test3 = in.nextInt();
System.out.println("Average test score is: " + (test3 + test2 + test1) / (NUM_TEST));