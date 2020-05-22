int[] array= {12, 23, -22, 0, 43,545, -4, -55, 43, 12, 0, -999, -87};


       int[] negativni= new int[array.length];
       int[] pozitivni= new int[array.length];

       int x;
        for ( x = 0; x <array.length; x++) 
        {
           if (array[x]<0) {
                  negativni[x]=array[x];
                }
            else if (array[x]>0) {
                pozitivni[x]=array[x];
             }
        }