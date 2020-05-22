public static void  printMan(int numMen) {

        for (int i = 0; i < numMen; i++) {
            String space ="" ,space2 ="";
            for(int j = numMen-i; j>1; j--) { 
                    space += "       ";
            }
            for(int k = 0; k<i ; k++) { 
                space2 += "       ";
             }

             System.out.println(space +" o  *****" + space2 + "*");
             System.out.println(space + "/|\\ *    "+ space2 + "*");
             System.out.println(space + "/ \\ *    "+ space2 + "*");             
        }

        for (int i = 0; i < (numMen *10)-((numMen-1) *3); i++) {
            System.out.print("*");
        }
    }
    }