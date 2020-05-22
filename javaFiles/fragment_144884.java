package numbergenerator;

    import java.util.Random;
    import java.util.Scanner;

    public class numbergenerator {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            Random r = new Random();

            int int1;
            int int2;
            int answer;
            int numbers;


            System.out.println("Enter your min range number: ");
            int1 = s.nextInt();

            System.out.println("Enter your max range number: ");
            int2 = s.nextInt();

            System.out.println("How many numbers do ya want? ");
            numbers = s.nextInt();

            for(int counter=0; counter<numbers; counter++){
            answer =r.nextInt(int2-int1)+int1;

            System.out.println(answer);
}

        }

    }