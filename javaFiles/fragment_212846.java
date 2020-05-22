String inputString, inputOption;
double meters = 0, kilometers, inches, feet;
int option = 0;

while(meters < 1)
{
    inputString = JOptionPane.showInputDialog("Enter the Meters value");
    meters = Double.parseDouble(inputString);
    if (meters < 1)
    {
    System.out.println("Invalid Meter value, please enter a value >= 1");
    option = 0;
    }
}

while(option != 4){
    System.out.println("Choose one of the Following"
            + "\n 1. Convert to Kilometers"
            + "\n 2. Convert to Inches"
            + "\n 3. Convert to Feet"
            + "\n 4. Exit");
    inputOption = JOptionPane.showInputDialog("Choose an Option");
    option = Integer.parseInt(inputOption);
    if(option == 1)
    {
        kilometers = meters*0.001;
        System.out.println(kilometers + "km");
    }
    else if(option == 2)
    {
        inches = meters*39.37;
        System.out.println(inches + "\"");
    }
    else if(option == 3)
    {
        feet= meters*3.281;
        System.out.println(feet + "'");
    }
    else if (option == 4)
    {
        System.out.println("The program will end");
    }
}