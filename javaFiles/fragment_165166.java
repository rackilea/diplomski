System.out.println("Sorry, You lose");
losses++;
System.out.println("Would you like to play again?");
next="No";
kbd.nextLine(); // to flush out new line character
more=kbd.nextLine();
more=more.toUpperCase();