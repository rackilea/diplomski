public int nextPrime(int start){
    int next = start+1;

    while(!isPrime(next)){
        next++;
    }

    return next;
}

public void arePrimeSequence(int r, int s, int a){
    int firstPrime = nextPrime(r);
    int secondPrime = nextPrime(firstPrime);

    if(s == firstPrime && a == secondPrime){
        System.out.println("YES");
    }
    else{
        System.out.println("NO");
    }
}