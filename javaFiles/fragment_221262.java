case 'l':   //If it is lower then 499 becomes the upperBound
            upperBound = nextGuess;
            tries++;
            nextGuess = ( (lowerBound + upperBound)/2 );
            System.out.println("Is it " + nextGuess + 
                 "? \n\t Enter y if it is, l if it is less, or m if it is more.");

            // **** here ****
            choice = console.next().charAt(0);

            System.out.println("LOWER");
            break;