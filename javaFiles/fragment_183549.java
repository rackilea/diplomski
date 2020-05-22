int attemps = 0;
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter Pin Code: ");
String PUK = null;
String PIN = null;
String CORRECT_PIN = "0123";
String CORRECT_PUK = "01234";
do{
        PIN  = keyboard.next();
        attemps++;
        if (!PIN.equals(CORRECT_PIN) && attemps < 3) 
            { 
               System.out.println("PIN is incorrect! Try again!" );
            }
     }while(!PIN.equals(CORRECT_PIN) && attemps < 3);
            if (PIN.equals(CORRECT_PIN) && attemps <= 3) {  
                System.out.println("Welcome!");  
            }
             else {
               System.out.println("PIN is incorrect! Try again with PUK");
               attemps = 0;
            do{
                PUK  = keyboard.next();
                attemps++;
                if (!PUK.equals(CORRECT_PUK) && attemps < 3) 
                    { 
                       System.out.println("PIN is incorrect! Try again!" );
                    }
             }while(!PUK.equals(CORRECT_PUK) && attemps < 3);
            if (PUK.equals(CORRECT_PUK) && attemps <= 3) {  
                System.out.println("Welcome!");  
            }
            else
            {
               System.out.println("PUK is incorrect! SIM Blocked! See you!");
            }
            }