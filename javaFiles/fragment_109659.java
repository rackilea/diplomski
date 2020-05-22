public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int userMoney = 2;
int compMoney = 2;
int userRoll = (int) (1 + Math.random() * 6);
int compRoll = (int) (1 + Math.random() * 6);

System.out.print("Press 'r' if you would like to roll ");
do {String roll = input.nextLine();
if (roll.equals("r")) {
    if (userRoll > compRoll){
        userMoney++;
        compMoney--;
 System.out.print("The computer rolled " + compRoll + " and you rolled "       + userRoll + ". you won."
    + "\n" + "You have $" + userMoney + " & The computer has $" + compMoney);
        }

        else if (userRoll < compRoll) {
            compMoney++;
            userMoney--;
            System.out.print("The computer rolled " + compRoll + " and you rolled " + userRoll + 
                    ". you lost" + "\n" + "You have $" + userMoney + " & The computer has $" + compMoney);
        }

        else {System.out.print("The computer rolled " + compRoll + "and you rolled " + userRoll + 
                ". it's a tie" + "\n" + "You have $" + userMoney + " & the computer has $" + compMoney);}


        }
         //prompt user to type 'r' to roll again
        System.out.println("\n\nPress 'r' if you would like to roll ");
        }while (userMoney > 0 && compMoney >0);

        System.out.println("\n\nGAME OVER!!!");
    }
   }
//end main