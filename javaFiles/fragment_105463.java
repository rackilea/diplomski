public static double cels(double input1)  /* this input1 needs to be fetched from scanner inside main method*/
{
double output1;
output1= input1 + 273.15;
System.out.println("temperature in rankine is:" +output1 );
return output1; 
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter a double value");
    double input = scanner.nextDouble();
    System.out.println("you have entered " + input);
    System.out.println(cels(input));
}