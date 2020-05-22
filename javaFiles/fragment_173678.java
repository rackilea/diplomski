int count = 0;
int noOfPrime = 0;
...
for(prime = lowerLimit ;prime < upperLimit; prime++){
    ...
    if(count==0){
       System.out.println(prime);
       noOfPrime+=1;
    }
}
if(noOfPrime >0)
    System.out.println("no primes);