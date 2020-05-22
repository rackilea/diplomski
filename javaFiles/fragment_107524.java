private static void print( int n ){

        int t = (int)Math.floor(n / 10);

        if (t > 0) {
            print(t);
            System.out.println( n % (t * 10) ); 
        }
        else 
            System.out.println( n );
    }