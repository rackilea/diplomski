public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("2"); 
    int n=2;
    while (n<1000)
    {
        for(int d = 2; d<n; d++) //if d|n abort divisors loop and try next number
        {

            if (n%d == 0){ //if d|n try next number
                break;
            }

            if (d>(n/2)){ 
                //if there are no divisors up to n/2 n is prime, print n
                //then try next number
                System.out.println(n);
                n++;
                break;
            }

        }  
        n++;
    }
}