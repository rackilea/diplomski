switch (state) 
     {
        case 0: 
            System.out.println();
            System.out.println("Do you want to enter another integer number? (y/n)");
            break;
        case 1:
            AnotherOrCloseIntToBinary.goodBye();
            return; // instead of break;
     }