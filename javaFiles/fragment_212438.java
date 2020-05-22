public class practice extends ConsoleProgram {

    public static int max(int num1, int num2) {
        int result;

        if (num1 > num2) 
            result = num1;
        else 
            result = num2;  

        return result;     
    }  

    public void run () {     
        for (int i = 0; i<=10; i+=2){
            for (int j = 1; j < 10; j*=2) {   
                System.out.println( max(i,j)); // instead of println() unless static import
            }
        }
    }
}