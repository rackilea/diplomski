public static void main(String[] args){
    System.out.println("\nWelcome\n");

    Scanner keyboard = new Scanner(System.in);

    int bombs = 60;
    int arrows = 2;
    boolean bow = true;
    double energy = 0.0;
    double monster = 3000;
    int you = 1000;

    System.out.println("\nMonster has appeared!!\n");

    System.out.println("\nHeres your inventory");
    System.out.println("\n60 bombs");
    System.out.println("\n2 ultra arrows");
    System.out.println("\n0.0 energy, you can recharge later if  you choose to do so");





    String ans = "Y";
    //change 1
    System.out.println("\nPick Weapon!");
    String input = keyboard.next();
    while(!(input.equalsIgnoreCase("bombs")) && !(input.equalsIgnoreCase("arrows")) && !(input.equalsIgnoreCase("energy"))){
        System.out.println("\nInvalid Weapon...\nRe-pick Weapon!");
        input = keyboard.next();
        if((input.equalsIgnoreCase("bombs")) && (input.equalsIgnoreCase("arrows")) && (input.equalsIgnoreCase("energy"))){
            break;
        }
    }
    //end of change 1

    while (ans.equalsIgnoreCase("Y"))
    {
        while (monster >= 0 && you >= 0)
        {
            //change 2.1
            if(input.equalsIgnoreCase("")){
                System.out.println("\nPick Weapon!");
                input = keyboard.next();
            }
            //end of change 2.1

            else{//change 2.2 (the else of the if statement above)
                if (input.equalsIgnoreCase("bombs"))
                {
                    if (bombs >= 0)
                    {
                        System.out.println("\nYou have chosen Bombs\n");
                        System.out.println("\nHit 9 to attack with big bombs which is -2 bombs or hit 8 for small bomb which is -1\n");
                        int choice1 = keyboard.nextInt();

                        if (choice1 == 9)
                        {
                                System.out.println("\nYou have chosen to attack with a big bomb 2 bombs ahve been taken from your inventory");
                                System.out.println("\nYou damaged the monster by 800\n");
                                monster -= 800;
                                bombs -= 2;
                                System.out.println("Now the monster has the health of" + monster + "\n");

                                System.out.println("\nHit Y to choose another weapon or N to back out of the fight");
                                ans = keyboard.next();
                         }//if end

                        else if (choice1 == 8)
                        {
                                System.out.println("\nYou have chosen to attack with a small bomb");
                                System.out.println("\nYou damaged the monster by 400\n");
                                monster -= 400;
                                bombs -= 1;
                                System.out.println("Now the monster has the health of" + monster + "\n");

                                System.out.println("\nHit Y to choose another weapon or N to back out of the fight");
                                ans = keyboard.next();

                        }//else if end of small bombs

                    }//end of if loop to do something i dont know i just leant this
                    else
                    {
                        System.out.println("\nYour bombs have depleted, please choose another weapon of your choice!");
                    }

                }//Bombs end

                else if (input.equalsIgnoreCase("arrows"))
                {
                    System.out.println("\nYou have chosen arrows as your weapon!");
                    if ((bow == true) && (arrows >= 1))
                    {
                        System.out.println("\nPlease press 1 to attack");
                        double arrowinput = keyboard.nextInt();

                        if (arrowinput == 1)
                        {
                        System.out.println("\nYou have only " + arrows + " left");
                        System.out.println("\nYou used Arrow and damaged the monster by 500 ");
                        monster -= 500;
                        arrows --;
                        System.out.println("\nNow the monster has the health of " + monster);
                        System.out.println("\nThe monster is still alive and is attacking you you have to kill it NOW CHOOSE A WEAPON SIR");
                        ans = keyboard.next();
                        }//end of attack and IF
                        else
                        {
                            System.out.println("\nYou have to chosen to be attacked by the monster and be eaten");
                            ans.equals("Y");
                        }//end of else
                    }//end of if to use the arrows and boolean

                    else
                    {
                        System.out.println("\nYou chose not to use the arrows now arrow is or you have run out of arrows arrow is unusable");
                        bow = false;
                    }//end of else to check for arrows

                }//end of bow

                else if (input.equalsIgnoreCase("energy"))
                {

                    System.out.println("\nYou have 0.0 energy and cannot use you have to wait for 5 seconds for it to charge up half or take a hit and go ALL OUT BABY");
                    try
                    {
                    Thread.sleep(5000);
                    }catch(InterruptedException e)
                    {
                    }
                        System.out.println("\nSystem has charges and is ready for use, press 1");
                        int inputattack = keyboard.nextInt();
                        energy += 3000;
                        if (inputattack == 1)
                        {
                            String inputofretry = "Y";
                            if ((energy >= 3000) && (inputofretry.equalsIgnoreCase("Y")))
                            {
                                System.out.println("\nYou have used all of your energy and did a damage of 1000 to the moster!");
                                monster -= 1000;
                                energy -= 3000;
                                System.out.println("\nNow the monster has a health of " + monster);
                                System.out.println("\nWould you like to use up your other half also or  use a diffrent weapon");
                                inputofretry = keyboard.next();
                                if (inputofretry.equalsIgnoreCase("N"))
                                {
                                    break;
                                }//end of break out of if
                            }//end of energy half use

                            else if (energy <= 0)
                            {
                                System.out.println("\nRan out of energy and you have been redirected to the refill of energy");
                                ans = "Y";
                            }

                    }//end of input attack



                }//end of energy

            }

        }//end of check for health
        break;

    }//While to change weapon


    if (you > monster)
    {
    System.out.println("\t\t\nYou have defeated the monster and have conquered the land of void so be happy!!\n");
    }
    else
    {
        System.out.println("\nYou have died and have bought a great dishono..... wait a minute you have 2 lives get yo ass up there and fight like aa man");
    }
}//end of main