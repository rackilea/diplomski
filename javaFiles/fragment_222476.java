boolean isValidInput = false;
  do{
    //check to make sure user entered a valid string
    strWord = in.nextLine();

    if(!(strWord.isEmpty()) && !(Character.isWhiteSpace(strWord.charAt(0))))
    {
        isValidInput = true;
        //whatever goes here
    } 
    else
       System.out.println("incorrect word entered");

    }while(!isValidInput);