import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TextPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TextPanel extends JPanel {

        private JTextArea inputArea, outputArea;

        public TextPanel() {

            initTextArea();
            initBorder();
            initLayout();

            packing();

        }

        private void packing() {

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(inputArea, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(outputArea, gbc);

        }

        private void initBorder() {

            Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            Border inner = BorderFactory.createTitledBorder("Text");
            setBorder(BorderFactory.createCompoundBorder(outer, inner));

        }

        private void initLayout() {

            setLayout(new GridBagLayout());

        }

        private void initTextArea() {

            // The borders are just here so you can see the different text areas
            inputArea = new JTextArea(10, 20);
            inputArea.setBorder(new LineBorder(Color.BLACK));
            outputArea = new JTextArea(10, 20);
            outputArea.setBorder(new LineBorder(Color.BLACK));

        }

    }
}