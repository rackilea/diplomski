int choice;

do { 

    System.out.print("Would you like to search by (1) Title or (2) Lexile # : ");
    choice = scan.nextInt();   

} while(choice < 1 || choice > 2); // Keep asking the user for a valid integer