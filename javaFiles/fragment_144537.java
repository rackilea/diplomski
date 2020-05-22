while (true) {
     if (firstch.equals("Good") || firstch.equals("Bad")) 
         break;  
     else {
         System.out.println("(I told you to write Good or Bad)");
         firstch = first.nextLine();
     }
 }