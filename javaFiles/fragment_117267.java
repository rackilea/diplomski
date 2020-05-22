for(int i = 0; i < 5; i++) {

         for(int j = i; j < 5; j++) {

             System.out.print(" ");

         }

        for(int k = 0; k <= (i*2); k++) {
            if(i%2==0)
            System.out.print("*");
        }
           System.out.println(); 
    }