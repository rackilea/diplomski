for(int i=1;i<=laenge;i++){

        for (int j=1; j<=laenge; j++) {

            if (i==j||(i+j)==(laenge+1))
                System.out.print("*");
            else
                System.out.print("-");
        }