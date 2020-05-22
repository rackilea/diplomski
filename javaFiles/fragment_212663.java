String letter = new String();
Scanner screen = new Scanner(System.in);
boolean inputOK = false;
while (!inputOK) {
      System.out.println("Enter ('y' or 'n': )");
      try {
          letter = screen.nextLine();

          if(!letter.equals("y") && !letter.equals("n")) {
              throw new InputMismatchException();
          }


          inputOK = true;
      } catch (InputMismatchException e) {

          System.out.println("\"" + letter + "\" is not a legal letter, " +
                "please try again!");

      } 
  } 
  System.out.println("That is a valid letter");