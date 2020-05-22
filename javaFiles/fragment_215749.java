import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RoulleteChecker {

    private static final int TIMES = 99999999;

    public static void main(String args[]) {

        int a[] = new int[36];

        for (long roll = 1; roll <= TIMES; roll++) {
            int r = (int) (Math.random() * a.length);
            ++a[r];
        }

        JTextArea outputArea = new JTextArea();

        outputArea.setText("Lets see:\n" + asString(a));

        JOptionPane.showMessageDialog(null, outputArea,
                "Searching for the frequency: " + TIMES + " times", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String asString(int[] s) {
        StringBuilder sb = new StringBuilder(8 * s.length);
        for (int i = 0; i < s.length; i++) {
            sb.append(i + 1).append(": ").append(s[i]).append("\n");
        }
        return sb.toString();
    }
}