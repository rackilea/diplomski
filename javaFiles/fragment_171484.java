public static boolean isPrime(int checkNumber) {
    double root = Math.sqrt(checkNumber); //get square root of candidate
    for (int i = 2; i <= root; i++) {  
        if (checkNumber % i == 0) { //if remainder of candidate/i = 0
            return false; //because candidate is not prime.  has factor other than 1 and self.
        }
    }
    return true;
}