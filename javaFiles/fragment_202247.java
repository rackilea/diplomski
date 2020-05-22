for (int i=0; i<diceNum; i++){
           int count = 0;
           System.out.printf("Reroll this die? (%d)\n",i);

           // Give three chances to user for correct input.. 
           // Else fill this array element with false value..

           while (count < 3 && !scansworth.hasNext("[YN]")) {
               count += 1;  // IF you don't want to get into an infinite loop
               scansworth.next();
           }    

           if (count != 3) {
                /** User has entered valid input.. check it for Y, or N **/
                responses[i] = (scansworth.next()).equals("Y") ? true : false;
           } 
           // If User hasn't entered valid input.. then it will not go in the if  
           // then this element will have default value `false` for boolean..
 }