public static int solution(int[]A,int K){
    int minIndex=0;
    int maxIndex=0;
    int end=A.length;
    int slize = end;
    int startIndex = 0;
    int diff = 0;
    int minMaxIndexDiff = 0;
    for(int currIndex=1;currIndex<end;currIndex++){
        if(A[currIndex]>A[maxIndex]){
            maxIndex=currIndex;
        }else if(A[currIndex]<A[minIndex]){
            minIndex=currIndex;
        }
        if( (A[maxIndex]-A[minIndex]) >K){
            minMaxIndexDiff= currIndex- startIndex;
            if (minMaxIndexDiff > 1){
                slize+= ((minMaxIndexDiff*(minMaxIndexDiff-1)) >> 1);
                if (diff > 0 ) {
                    slize = slize + (diff * minMaxIndexDiff);
                }
            }

            if (minIndex == currIndex){
                diff = currIndex - (maxIndex + 1);
            }else{
                diff = currIndex - (minIndex + 1);
            }
            if (slize > 1000000000) {
                return 1000000000;
            }
            minIndex = currIndex;
            maxIndex = currIndex;
            startIndex = currIndex;
        }
    }
    if ( (startIndex +1) == end){
        return slize;
    }
    if (slize > 1000000000) {
        return 1000000000;
    }
    minMaxIndexDiff= end- startIndex;
    if (minMaxIndexDiff > 1){
        slize+= ((minMaxIndexDiff*(minMaxIndexDiff-1)) >> 1);
        if (diff > 0 ) {
            slize = slize + (diff * minMaxIndexDiff);
        }
    }

    return slize;
}