ArrayList<Integer> mins = new ArrayList<Integer>();
    ArrayList<Integer> maxs = new ArrayList<Integer>();

    int prevDiff = array[0] - array[1];
    int i=1;
    while(i<array.length-1){    
        int currDiff = 0;
        int zeroCount = 0;
        while(currDiff == 0 && i<array.length-1){
            zeroCount++;
            i++;
            currDiff = array[i-1] - array[i];
        }

        int signCurrDiff = Integer.signum(currDiff);
        int signPrevDiff = Integer.signum(prevDiff);
        if( signPrevDiff != signCurrDiff && signCurrDiff != 0){ //signSubDiff==0, the case when prev while ended bcoz of last elem
            int index = i-1-(zeroCount)/2;
            if(signPrevDiff == 1){
                mins.add( index );
            }else{
                maxs.add( index );
            }               
        }
        prevDiff = currDiff;
    }