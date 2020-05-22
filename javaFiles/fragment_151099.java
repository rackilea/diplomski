import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JFrame frame = new JFrame("JLabel Text Example");

                final HashMap<String, JLabel> yourMap = new HashMap<>();
                yourMap.put("12345", new JLabel("Example Text"));
                yourMap.put("54321", new JLabel("Other Text"));

                final JTextField input = new JTextField(5);
                input.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text = input.getText();
                        if(yourMap.get(text) != null) {
                            yourMap.get(text).setEnabled(!yourMap.get(text).isEnabled());
                        }
                    }

                });

                final JPanel labels = new JPanel();
                labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
                for(JLabel label : yourMap.values()) {
                    labels.add(label);
                }

                frame.getContentPane().add(input);
                frame.getContentPane().add(labels, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });
    }

}