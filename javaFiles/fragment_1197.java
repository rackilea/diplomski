package mainaxe;

public class Mainaxe {

    public static void main(String arg[]) {
        Timex n = new Timex();
        n.start();
//        int n2 = Timex.a;
//        n.timedel();
        for (int i = 0; i < 20; i++) {
            System.out.println("the time is :" + Timex.a);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}