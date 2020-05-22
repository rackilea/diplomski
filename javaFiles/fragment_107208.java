if (Go.equalsIgnoreCase("kitchen")) {
    System.out.println("There is a long countertop with dirty dishes everywhere. Off to one side there is, as you'd expect, a refrigerator. You may open the 'refrigerator' or look in the 'pantry'. ");
}
System.out.print(">  ");
Look = keyboard.next();

if (Look.equalsIgnoreCase("refrigerator")) {
    System.out.println("Inside the refrigerator you see food and stuff. It looks pretty nasty. Would you like to eat some of the food, 'Yes' or 'No'?");
}
System.out.print(">  ");
Eat = keyboard.next();