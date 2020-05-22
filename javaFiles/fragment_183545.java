int attemps = 0;
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter Pin Code: ");
int PIN = 0;
int PUK = 0;
int CORRECT_PIN = 123;
int CORRECT_PUK = 1234;
while(PIN != CORRECT_PIN && attemps < 3)
        {
            PIN  = keyboard.nextInt();
            attemps++;
            if (PIN != CORRECT_PIN && attemps < 3) { 
               System.out.println("PIN is incorrect! Try again!" ); // This is the 1st time the wrong password has been entered.
            }
        }
        if (PIN == CORRECT_PIN && attemps <= 3) {  
            System.out.println("Welcome!");  
        }
         else {
           System.out.println("PIN is incorrect! Try again with PUK");
           attemps = 0;
           while(PUK != CORRECT_PUK && attemps < 3)
           {
            PUK  = keyboard.nextInt();
            attemps++;
            if (PUK != CORRECT_PUK && attemps < 3) { 
               System.out.println("PUK is incorrect! Try again!"); // This is the 1st time the wrong password has been entered.
            }
           }
        if (PUK == CORRECT_PUK && attemps <= 3) {  
            System.out.println("Welcome!");  
        }
        else
        {
           System.out.println("PUK is incorrect! SIM Blocked! See you!");
        }
        }