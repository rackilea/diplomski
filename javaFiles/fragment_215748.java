import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RoulleteChecker {

    public static void main(String args[]) {

        int a[] = new int[37];

        for (long roll = 1; roll <= 99999999; roll++) {
            a[0] = 1 + (int) (Math.random() * 34);
            ++a[a[0] + 1];
        }

        JTextArea outputArea = new JTextArea();

        outputArea.setText("Lets see: " + IntStream.of(a).limit(36).boxed().collect(Collectors.toList()).toString().replace(", ", "\n"));

        JOptionPane.showMessageDialog(null, outputArea,
                "Searching for the frequency: 99999999 times", JOptionPane.INFORMATION_MESSAGE);

    }
}