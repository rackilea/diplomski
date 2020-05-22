System.out.print("\nPlease type the numbers that correspond to the food you would like to order separated by spaces: ");

do{
    toneorder = userInput.nextInt();
    switch (toneorder) {
case 1: tonefood = "Hamburger";
    break;
case 2: tonefood = "Cheeseburger";
    break;
case 3: tonefood = "Chicken Wrap";
    break;
case 4: tonefood = "Chicken Nuggets";
    break;
case 5: tonefood = "Lrg French Fries";
    break;
case 6: tonefood = "Sml French Fries";
    break;
case 7: tonefood = "Bottled Water";
    break;
case 8: tonefood = "Lrg Soda";
    break;
case 9: tonefood = "Sml Soda";
    break;
}while (userInput.hasNextInt());