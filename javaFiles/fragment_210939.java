int middleSpaces = sides * 2;   //NOTICE
        int downPreSpaces = 1;
        int dRows = sides + 1;    
        for (int x = 1; x <= dRows; x++) {
            if (x >= dRows) {
                for (int z = 1; z <= sides + 1; z++) {
                    System.out.print(" ");
                }
                System.out.print("v");
            }    
            if (x != dRows) {    
                for(int y = 1; y <= x; y++) {
                    System.out.print(" ");
                }    
                System.out.print("\\");    
                for (int e = middleSpaces - 2; e >= 0; e -= 1) {
                    System.out.print(" ");
                }
                middleSpaces-=2;   //NOTICE
                System.out.print("/\n");
            }