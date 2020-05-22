int amountOfYears = rain.length/12-3;
    double maxRAINyear[]= new double [amountOfYears];
    for(int i=0;i<amountOfYears;i++){

        //Find maximum for these 12 indixes
        double max = Double.NEGATIVE_INFINITY;
        for(int j=12*i+36;j<12*(i+1)+36;j++){ //use 12*i as an offset, that way, you don't need a temp array
            if(rain[j] > max)
                max = rain[j];
        }
        //store maximum
        maxRAINyear[i] = max;

    }