for (int year = 2000; year <= 2100; year++) {
//checking each year from 2000 to 2100
    if (year%4==0 || year%100==0 && !not)
         System.out.println (year + " is a leap year");

        else
            System.out.println (year + " is not a leap year");
        }
    }