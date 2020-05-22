switch (comp){
     case 0: System.out.println("The computer chose Rock!"); 
     switch (user){
        case 0: System.out.println("You chose Rock! It's a draw!"); break;
        case 1: System.out.println("You chose Paper! You win!"); break;
        case 2: System.out.println("You chose Scissors! You loose!"); break;
        }
     break;
     case 1: System.out.println("The computer chose Paper!"); 
     switch (user){
        case 0: System.out.println("You chose Rock! You loose!"); break;
        case 1: System.out.println("You chose Paper! It's a draw!"); break;
        case 2: System.out.println("You chose Scissors! You win!"); break;
        }
     break;
     case 2: System.out.println("The computer chose Scissors!");
     switch (user){
        case 0: System.out.println("You chose Rock! You win!"); break;
        case 1: System.out.println("You chose Paper! You loose!"); break;
        case 2: System.out.println("You chose Scissors! It's a draw"); break;
        }
     break;
     }