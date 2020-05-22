public class ExamQ32 {
public static void say(String s) {
    System.out.print(s);

}

public static void main(String[] args) {
    Thread letters = new Thread() {
        public void run() {
            synchronized (ExamQ32.class) {
                say("a");
                say("b");
                say("c");
            }
        }
    };

    Thread numbers = new Thread() {
        public void run() {
            synchronized (ExamQ32.class) {
                say("1");
                say("2");
                say("3");
            }
        }
    };
    letters.start();
    numbers.start();
}