System.out.println("Please enter a number of your choice from 0 to 10");
 String userChoiceStr = scanner.next();
 try{
     userChoice = Integer.parseInt(userChoiceStr);
     if(userChoice >=0 && userChoice <=10)
         System.out.println(message.get(userChoice));
     else
         System.out.println("The number you entered is not valid.");
 } catch (NumberFormatException e) {
    System.out.println("The number you entered is not valid.");
 }