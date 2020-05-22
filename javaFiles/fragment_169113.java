int index = 0;
           int min = rainfall[index];
           for (int i=1; i<rainfall.length; i++){

               if (rainfall[i] < min ){
                   min = rainfall[i];
                   index = i;
               }


       }
    System.out.println("Lowest rainfall month is :" month[index]);
System.out.println("had the lowest rainfall: "+min);