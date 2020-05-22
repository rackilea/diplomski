int maxCount = 0;
int loopCount;

for(long i = startingPoint; i <= endingPoint; i++) {

    long number = i;
    loopCount = 1;

    while(number != 1) {
        if(number%2 == 0) {
            number = number/2;
        } else if(number%2 != 0) {
            number = (3*number)+1;
        }
        loopCount++;
    }
    if(loopCount > maxCount){
        maxCount = loopCount;
    }
    System.out.println("Number: " + i + ". " + "Loop count: " + loopCount + ".");
}
System.out.println("Highest loopCount : " + maxCount);