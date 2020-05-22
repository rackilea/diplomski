public class Test {
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a letter:");
        char c = in.next().charAt(0); //there's no in.nextChar :(
        c++; //start out one character ahead
        for(; c <='y'; c++){
            System.out.println("And the next character is: " + c);
        }
    }
}