int largest = userInput.get(0);
       for(int i = 1; i < userInput.size(); i++)
       {
           if (largest < userInput.get(i)) 
           {
               largest = userInput.get(i);
           }
       }
       System.out.println("Largest number is: " + largest);