Scanner input1 = new Scanner(System.in);
System.out.println("Enter 10 numbers: ");
double myValues = 0;

for (int count = 0; count < n; count++) {
    double myValues = input1.nextDouble(); 
    sum1 += myValues;
    sqrdSum += Math.pow(myValues, 2);
    System.out.println(sum1 + " " + sqrdSum); //this is to test to see if the loop is calculating correctly.
}