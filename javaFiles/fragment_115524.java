public class myProgram //class that contains your code
{
public static void main(String [] args) //main method is always called at runtime
{
    opdracht3b1(num1,num2,num3); //fill in numbers with the 3 numbers you want 
}
public static void opdracht3b1(double x, double y, double z){
    double[] numbers = new double[] {x, y, z};
    double smallestNumber = x;

    for(double number : numbers){
        if(number < smallestNumber){
            smallestNumber = number;
        }
    }

    System.out.println("Input numbers: " + x + ", " + y + ", " + z + ".");
    System.out.println("Smallest Number: " + smallestNumber + ".");
}
}