public class HelloWorld{

     public static void main(String []args){
        int count=1;
        int userNum = 3;
        char userLetter = 0;

        userLetter = 'A';
        while (count <= userNum) {
            System.out.print( (char)(userLetter+count));
            count++;
        }
             }
}