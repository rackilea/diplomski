public class Test {
    public static void main(String...rDX) {
        runing: for (;;) { // infinite loop
            for (int i = 1; i < 10; i++)
                System.out.print(i);
            for(int i = 1; i < 10; i++) {
                if (i == 5) {
                    continue runing;
                }
            }
            break; // = break runing; effectively never reached
                   // because above "continue" will always happen
        }
    }
}