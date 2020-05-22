import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Test extends JFrame {

    public Test() {
        Set<Object> options = new HashSet<>();
        options.add(new Option<Integer>("One", 1));
        options.add(new Option<Integer>("Two", 2));
        options.add(new Option<Integer>("Three", 3));
        options.add(new Option<Integer>("Four", 4));
        CheckComboBox c = new CheckComboBox(options);
        this.add(c);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void main(String[] args) {
        new Test();
    }


    private class Option<T> implements Comparable<T> {
        private String label;
        private T value;

        public Option(String label, T value) {
            this.label = label;
            this.value = value;
        }

        @Override
        public String toString() {
            return this.label;
        }

        @Override
        public int compareTo(T o) {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}