int max = 0;
    int nextMax = 0;
    int maxItem = 0;
    for(int i = 0; i < myInts.size(); i++) {
        if(i == 0 )
            continue;
        if(myInts.get(i) == myInts.get(i-1)) {
            if(max > nextMax ) {
                nextMax = max;
                maxItem = myInts.get(i);
            }
            else {
                max++;
                nextMax = max;
                maxItem = myInts.get(i);
            }
        } else {
            max = 0;
        }
    }
    System.out.println(maxItem);