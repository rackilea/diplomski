public static String comment(int score, int parForHole) {       
        switch (score - parForHole) {
            case -4:  
                     return "condor!!!!";
            case -3:  
                     return "albatross!!!";
            case -2:  
                     return "eagle!!";
            case -1:  
                     return "birdie!";
            case 0:  
                     return "par";
            case 1:  
                     return "bogey";
            case 2:  
                     return "double bogey";
            case 3:  
                     return "triple bogey";
            default: 
                     return "Invalid";
        }
}