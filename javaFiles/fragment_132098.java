System.out.print(Winner.getWinnerWinnings(Winner.WINNER)); //this is called in the other class 

public static int getWinnerWinnings(Winner win){
     int winnings = getWinnings(win);
     return winnings;
 }
 public static int getWinnings(Winner Win)
    {

        int winningsAmount;
        switch(Win)