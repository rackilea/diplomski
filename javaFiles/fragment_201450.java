public static void main(String[] args) {
    long number= 600851475143L;
    int rootOfNumber = (int)Math.sqrt(number)+10;
    for(int i = rootOfNumber; i > 2; i--) {
        if(number % i == 0) {
            if(psudoprime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

}

public static boolean psudoprime(int num) {
    for(int i = 2; i < 100; i++) {
        if(num % i == 0) {
            return false;
        }
    }
    return true;
}