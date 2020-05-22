public class Main {
    public static void main(String[] args) {
        System.out.println("Number of args:" + args.length);

        for(int i=0; i<args.length; i++){
            char dollar = '\u0024';
            System.out.println(dollar + args[i].toUpperCase());
        }

    } 
}