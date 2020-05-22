import java.util.Scanner; 
import java.util.TreeMap; 

public class Test{
    public static void main( String args[] ){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> factors = new TreeMap<Integer, Integer>(); 

        for (int i = 2; i <= n / i; i++) {
            int count = 0; 

            while (n % i == 0) {
                System.out.print(i + ", ");
                n /= i;
                count ++; 
            }
            if( count > 0 ) 
                factors.put( i, count ); 
        }
        if (n > 1){
            System.out.print(n + ", ");
            factors.put( n, 1 ); 
        }
        System.out.println(); 

        System.out.println( "-------------" ); 
        for( Integer factor : factors.keySet() ){
            System.out.println( factor + "^" + factors.get( factor ) ); 
        }
    }
}