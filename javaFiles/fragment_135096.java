int people = 15000000;
    int[] arrayofcity = new int[3000];
    int sharedSpread=people/3000;                 // sharedSpread= avg population
    for (int i = 0; i < arrayofcity.length; i++) {

        if(i%2!=0)
          arrayOfCity[i] = sharedSpread + (sharedSpread-arrayOfCity[i-1]);
        else
            {
             Random r = new Random();
             int val = Random.nextInt();
             arrayOfCity[i] = val%sharedSpread ;   

            }

    }