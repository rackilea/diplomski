import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


                JComboBox jc = new JComboBox(new String[]{"Hello", "Bye", "World", "Cruel"});
                jc.setEditable(true);
                frame.add(jc);

                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        new Test();
    }
}