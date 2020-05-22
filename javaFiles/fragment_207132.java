if(CLIENT.length() == 16){ //lenght
            RETRY_CLIENT = 5;//this variable is set to 5 breaking the loop when the client is valid
            while(RETRY_NIP < 4){//while the RETRYNIP is less than four then the nip is requested
                System.out.println("Insert NIP");
                System.out.printf(PROMT);
                PASSWORD = keyboard.nextLine();//NIP is requested
                System.out.println();
                if(PASSWORD.length() == 4){ //if nip length is equal to 4
                    System.out.println("Welcome to your account user " +CLIENT); //gives welcome
                    RETRY_NIP = 5; //entonces se pone como 5 rompiendo el loop
                }
                else if(PASSWORD.length() != 4 && RETRY_NIP == 4){ //if the password length is diferent from 4 and retryNIP is equal to 4 attempts
                    Cashier.close(); //Cashier closes
                }
                else if(PASSWORD.length() != 4){// if the NIP Lenght is diferent from 4 then the NIP is requested again, RETRYNIP increases in 1
                    System.out.println(TRY);
                    RETRY_NIP ++; //RetryNIP is increased in one (+1)
                }
            }
        }
        else if(CLIENT.length() != 16 && RETRY_CLIENT == 4){ //IF the lenght of the user is diferent from 16 and the Retry Client equals then the cashier closes
            Cashier.close();
        } 
        else if(CLIENT.length() != 16){//if the clientlenght is diferent from 16 then the retry client increases in one (+1)
            System.out.println(TRY);
            RETRY_CLIENT ++;
        }