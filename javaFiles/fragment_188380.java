System.out.println("Please enter book title: ");
title = keyboard.nextLine();
title = keyboard.nextLine();
System.out.println("Please enter book author: ");
author = keyboard.nextLine();
onLoan = false; // not used yet
if (choice == 1) { // Use constant or enum here
    book1 = new fiction(title,author);
    System.out.println(book1.toString());
}
else if (choice == 2) { // Use constant or enum here
   book1 = new nonfiction(title,author);
   System.out.println(book1.toString());
}