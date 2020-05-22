int iteration = 0;
float number;
float total = 0;
float average;
float lowest = Float.MAX_VALUE;


Scanner input = new Scanner(System.in);

while (iteration < 4){
    System.out.println("Enter score : ");
    number = input.nextFloat();

    iteration++;

    total += number;

    if(number < lowest){
        lowest = number;
    }

}

average = total / 4;
System.out.println("The average is: " + average);
System.out.println("The minimum is: " + lowest);