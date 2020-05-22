int amountOfYears = Math.ceil(rain.length/12f)-3;
    double maxRAINyear[]= new double [amountOfYears];
    for(int i=0;i<amountOfYears;i++){

        //Find maximum for these 12 indixes
        double max = Double.NEGATIVE_INFINITY;
        int start = 12*i+36;
        int end = Math.min(rain.length,12*(i+1)+36);
        for(int j=start;j<end;j++){ //use 12*i as an offset, that way, you don't need a temp array
            if(rain[j] > max)
                max = rain[j];
        }
        //store maximum
        maxRAINyear[i] = max;

    }