public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.print("How many players? ");
            int playerCount = scan.nextInt(); // get number of participant player...
            scan.nextLine();

            Die[] tempDie = new Die[5]; // temporary purpose
            Die[][] finalDie = new Die[5][]; // final array in which all rolled dies stores...

            String [] playerName = new String[playerCount]; // stores player name

            int totalRollDie = 0; // keep track number of user hash rolled dies...

            for(int i = 0; i < playerCount; i++) // get all player name from command prompt...
            {
                System.out.print("What is your name: ");
                String plyrName = scan.nextLine();
                playerName[i] = plyrName;
            }

            for(int i = 0; i < playerCount; i++){ 

                System.out.println(playerName[i] + "'s turn....");
                    totalRollDie = 0;
                    Die d = new Die();
                    System.out.println("Rolled : " + d.roll()) ;
                    tempDie[totalRollDie] = d; 
                    totalRollDie++;
                    System.out.println("Want More (Yes/No) ???");
                    String choice = scan.next();

                        while(choice != null && choice.equalsIgnoreCase("YES")){
                            if(totalRollDie < 5){ // if user want one more time to roll die then first check whether alread user has rolled 5-time or not.
                            Die dd = new Die();
                            System.out.println("Rolled : " + dd.roll()) ; // rolled and print whatever value get..
                            tempDie[totalRollDie] = dd;
                            totalRollDie++;
                            System.out.println("Want More (Yes/No) ???");
                            choice = scan.next();
                        }
                    }

                    finalDie[i] = new Die[totalRollDie];
                    for(int var = 0 ; var < totalRollDie ; var++){
                        finalDie[i][var] = tempDie[var]; // store Die object into finalDie array which can random number for all user.. 
                    }
            }

            for(int i = 0 ;i < playerCount ; i++){ // finally print whatever user's roll value with all try...
                System.out.println(" --------- " + playerName[i] + " ------------ ");
                for(Die de : finalDie[i]){
                    System.out.println(de);
                }
            }

            tempDie = null;

        }