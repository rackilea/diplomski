public static void testGetRandomPermutation () {

    int length =4;  // length of arrays to construct

    // This code tests the DISTRIBUTIONAL PROPERTIES
    ArrayList<Integer> counts = new ArrayList <Integer> ();  // filled with Integer
    ArrayList<int[]> arrays = new ArrayList <int[]> ();  // filled with int[]

    int T = 1000000; // number of trials
    for (int t = 0; t < T; t++) {           
        int[] perm = getRandomPermutation(length);
        // System.out.println (getString (perm));
        boolean matchFound = false;
        for(int j = 0; j < arrays.size(); j++) {
            if(equals(perm,arrays.get(j))) {
                //System.out.println ("match found!");
                matchFound = true;
                // increment value of count in corresponding position of count list
                counts.set(j, Integer.valueOf(counts.get(j).intValue()+1));
                break;
    }                       
        }
        if (!matchFound) {
            arrays.add(perm);
            counts.add(Integer.valueOf(1));
        }   
    }

    for(int i = 0; i < arrays.size(); i++){
        System.out.println (getString (arrays.get (i)));
        System.out.println ("frequency: " + counts.get (i).intValue ());
    }

    // Now let's test the speed
    T = 500000;  // trials per array length n       
    // n will the the length of the arrays
    double[] times = new double[97];
    for(int n = 3; n < 100; n++){
        long beginTime = System.currentTimeMillis();
        for(int t = 0; t < T; t++){
            int[] perm = getRandomPermutation(n);
        }
        long endTime = System.currentTimeMillis();
        times[n-3] = (double)(endTime-beginTime);
        System.out.println("time to make "+T+" random permutations of length "+n+" : "+ (endTime-beginTime));
    }
    // Plotter.plot(new double[][]{times});     
}