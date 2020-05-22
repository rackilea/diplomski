do{
      userInput = mainMenu();
      if(isUserInputValid(userInput))
        ...
      else System.out.println("\nMainMenu");
    } while(!(wantToQuit));