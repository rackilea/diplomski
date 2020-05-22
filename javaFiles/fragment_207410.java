public void firstHalfMean(){
        int i;
        double sum = 0;
        int numberOFElements = NrElmts/2;
        for (i = 0; i < NrElmts/2; i++) {   // take sum only till half.
            sum += a[i];
        }
        double mean = sum / numberOFElements;   // sum/half the elements
        System.out.format("Mean is: %.1f", mean);
        System.out.println("");
    }

    public void secondHalfMean(){
        int i;
        double sum = 0;
        int numberOFElements = NrElmts % 2 == 0 ? NrElmts/2 : NrElmts/2 + 1; // If odd, this second array will contain one more element.
        for (i = NrElmts/2; i < NrElmts; i++) {   // take sum for the next half
            sum += a[i];
        }
        double mean = sum / numberOFElements;  // sum/half elements  (half + 1) in case of odd length.
        System.out.format("Mean is: %.1f", mean);
        System.out.println("");
    }