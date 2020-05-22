public static void main(String[] args) {

    temperatures();

}
public static void temperatures(){
    int counter = 0;
    double temperature; 
    double totalNum = 0; 
    int numberAmount = 0;
    double max = - Double.MAX_VALUE;
    double min = Double.MAX_VALUE;
    double average = 0;

    Scanner input = new Scanner(System.in);

    System.out.println("Please enter the temperature(s) - end the program with -100");
    System.out.print("-> ");


    while ((temperature = input.nextDouble()) != -100) {
      //  temperature = input.nextDouble();
        counter++;
        numberAmount++;
        totalNum = totalNum + temperature;
        System.out.print("-> ");

        if(temperature > max)
        {
            max=temperature;

        }

        if(temperature < min)
        {
            min = temperature;
        }

    }

    average = totalNum/numberAmount;
    System.out.println();
    System.out.println("Highest temperature: " + max);
    System.out.println("Lowest temperature: " + min);
    System.out.println("Average temprature: " + average); 
    System.out.println("Total registered tempratures: " + counter);



}