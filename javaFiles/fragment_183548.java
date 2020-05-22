String PIN = null;
String CORRECT_PIN = "0123";
do{
        PIN  = keyboard.next();
        attemps++;
        if (!PIN.equals(CORRECT_PIN) && attemps < 3) 
            { 
               System.out.println("PIN is incorrect! Try again!" );
            }
     }while(!PIN.equals(CORRECT_PIN) && attemps < 3);