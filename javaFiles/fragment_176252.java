boolean tryAgain = false;
    do{
         try {

             if(tryAgain)
             {
                System.out.println ();

                System.out.print ("Do you want to try again?");
                System.out.println ();
                System.out.print ("Input '1' to go again OR any other key to End.: ");
                counter = keyBoard.nextInt ();
                tryAgain = false;
             }

            System.out.print ("Volume of a cone... V = 1/3(3.14)r^2(h)");
            System.out.println ();
            System.out.print ("Input Radius: ");
            radius = keyBoard.nextDouble ();
            System.out.print ("Input Height: ");
            height = keyBoard.nextDouble ();
         //math
            volume = 0.333 * pie * radius * radius * height;
            System.out.printf ("Volume =   " + volume);
            tryAgain = true;
         }//end try
         catch (Exception Error){
            System.out.println ("You Entered the Wrong Data.");
            keyBoard.nextLine();
            tryAgain = true;
         }

      }while (counter == 1);