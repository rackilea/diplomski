double numTosses = 100; //choose whatever here
double threeTails = 0;
for(int i =0; i < numTosses; i++){
    if(isThreeTails()){
         threeTails++;
    }
}
System.out.println("Theoretical probability of 3 Tails: " + (double) 1/8);
System.out.println("Actual results for " + numTosses + " tosses = " + threeTails/numTosses);