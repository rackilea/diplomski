public class BMIprogram {

  public static void main(String[] args) {

    double BMI;
    double weight;
    double height;

    Scanner bodymassScan = new Scanner(System.in);

    System.out.println("Enter weight in pounds: ");
    weight = bodymassScan.nextInt();

    System.out.println("Enter height in inches: ");
    height = bodymassScan.nextInt();

    BMI = ((weight/Math.pow(height, 2)) * 703);

    System.out.println(BMI + " is the BMI");

    }
}