import java.awt.GridLayout;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static Vector<int[]> v;
    public static JButton[][] buttons;
    public static int n1 = 100, n2 = 100, N = 50000;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(n1, n2));

        buttons = new JButton[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                buttons[i][j] = new JButton(String.format("%d,%d", i, j));
                f.add(buttons[i][j]);
            }
        }
        f.setSize(1024, 768);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        v = new Vector<int[]>();
        Random r = new Random();
        for (int i = 0; i < N; i++)
            v.add(new int[] {r.nextInt(n1), r.nextInt(n2), r.nextInt(2)});

        for (int i = 0; i < 10; i++) {
            test1();
            test2();
        }
    }

    public static void test1() {
        reset();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int[] test : v) {
                    buttons[test[0]][test[1]].setEnabled(test[2] == 1);
                }
                System.out.println(String.format("Test1   -> took %dms", System.currentTimeMillis() - start));
            }
        }).start();
    }

    public static void test2() {
        reset();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int[] test : v) {
                    if (buttons[test[0]][test[1]].isEnabled() != (test[2] == 1)) buttons[test[0]][test[1]].setEnabled(test[2] == 1);
                }
                System.out.println(String.format("Test2   -> took %dms", System.currentTimeMillis() - start));
            }
        }).start();
    }

    public static void reset() {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                buttons[i][j].setEnabled(true);
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
    }
}