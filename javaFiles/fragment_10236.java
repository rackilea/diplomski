for(int i = 0; i < temperatures.length; i++)
    {
        System.out.println("Please enter the temperature for day " + (i+1));
        temperatures[i] = new Data(input.nextDouble());
    }
input.nextLine();       // Add this to consume the newline
String choice = "";
int numberChoice;
System.out.println("Please select one of the following options");
choice = input.nextLine();
numberChoice = Integer.parseInt(choice);