private boolean isPrime(int num){
    // assuming positive ints
    if( num <= 2 || num % 2 == 0) 
        return false;
    for(int divisor = 3; divisor <= (int)Math.pow(num, 0.5); divisor+=2)
        if( num % divisor == 0) 
            return false;
    return true
}

public void number(int start, int end){
    if( start <= end ){
        for( int curr = start; curr <= end; curr++ ){
            if( curr % 2 == 1 ) {
                System.out.println(curr + " : Odd");
                if(isPrime(curr))
                    System.out.println(curr + " : Prime");
            } else System.out.println(curr + " : Even");
        }
    }