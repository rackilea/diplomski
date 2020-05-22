public class BMIProj {
    static Scanner input = new Scanner(System.in);

    // Class vars
   int height;
   int weight;
   double bmi;

   //Constructor
   public BMIPrj(){
     //Initialize vars 
     height = 0;
     weight = 0;
     bmi = 0;
   }

    public static void heightInInches()
    {

       System.out.println("Input feet: ");
       int x;
       x = input.nextInt();
       System.out.println("Input Inches: ");
       int y;
       y = input.nextInt();

       int height = x * 12 + y;

       return height; 
    }

    public static void weightInPounds()
    {
        System.out.println("Input stone: ");
        int x;
        x = input.nextInt();
        System.out.println("Input pounds ");
        int y;
        y = input.nextInt();

        int weight = x * 14 + y;

        return weight;
    }

    public static void outputBMI()
    {
      System.out.println("BMI: " + (( weight / height ) x 703));
    }

    public static void main(String[] args) {

        heightInInches();
        weightInPounds();
        outputBMI();

    }