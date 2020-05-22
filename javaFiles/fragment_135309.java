Object[] possibleChoices = {"Car", "Truck"};
Object choice = JOptionPane.showInputDialog(null, "Choose a vehicle type", "Choose Vehicle", JOptionPane.PLAIN_MESSAGE, null, possibleChoices, possibleChoices[0]);

switch (choice.toString)
{
    case "Car": 
        //insert code for if this choice is made
        break;
    case "Truck":
        //insert code for if this choice is made
        break;
}

Object[] carChoices = {"Honda", "Nissan", "Acura"};
Object[] truckChoices = {"Ford", "GM"};
Object choice2;

switch (choice.toString)
{
    case "Car": 
        choice2 = JOptionPane.showInputDialog(null, "Choose a car type", "Choose Car", JOptionPane.PLAIN_MESSAGE, null, carChoices, carChoices[0]);
        break;
    case "Truck":
        choice2 = JOptionPane.showInputDialog(null, "Choose a vehicle type", "Choose Vehicle", JOptionPane.PLAIN_MESSAGE, null, truckChoices, truckChoices[0]);
        break;
}

switch (choice2.toString())
{
    case "Honda": 
        //code for this choice; 
        break;
    case "Nissan":
        //code for this choice; 
        break;
    case "Acura":
        //code for this choice; 
        break;
    case "Ford":
        //code for this choice; 
        break;
    case "GM":
        //code for this choice; 
        break;
}