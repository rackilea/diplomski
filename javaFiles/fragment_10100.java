System.out.println("\nQ1) What is the capital of Alaska?");
System.out.println("\n\t 1) Melbourne");
System.out.println("\n\t 2) Anchorage");
System.out.println("\n\t 3) Juneau\n");
selection = keyboard.nextInt();

switch (selection) {
    case 3:
        System.out.println("\nThat's correct!");
        score++;
        break;
    case 1:
    case 2:
        System.out.println("\nSorry, that's incorrect.");
        break;
    default:
        System.out.println("Invalid selection!");
        break;
}

System.out.print("\nQ2) Can you store the value 'cat' in a variable of type int? ");
answer = keyboard.next();

switch (answer) {
    case "No":
    case "no":
        System.out.println("\nThat's correct!");
        score++;
        break;
    case "Yes":
    case "yes":
        System.out.println("\nSorry, 'cat' is a string. Int type variables can only store numbers."); 
        break;
}

System.out.print("\nQ3) What is the result of 9+6/3?");
System.out.println("\n\t 1) 5");
System.out.println("\n\t 2) 11");
System.out.println("\n\t 3) 15/3\n");
selection = keyboard.nextInt();

switch (selection) {
    case 2:
        System.out.println("\nThat's correct!\n");
        break;
    default:
        System.out.println("Invalid selection!");
        break;      
}