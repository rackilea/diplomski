System.out.println("Please enter a number of your choice from 0 to 10");
 userChoice = scanner.nextInt();
 if(userChoice >=0 && userChoice <=10)
     System.out.println(message.get(userChoice));
 else
     System.out.println("The number you entered is not valid.");