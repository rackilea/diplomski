System.out.println("Enter rock (1), paper (2), or scissors (3) [\'n\' to quit]: ");

char selection = scanner.nextLine().charAt(0)
if(selection == '1'){ user = "R"; }
else if(selection == '2'){ user = "P"; }
else if(selection == '3'){ user = "S"; }
else if(selection == 'n'){
    System.out.println(ties)
    System.out.println(wins);
    System.out.println(losses);
    return;
    }