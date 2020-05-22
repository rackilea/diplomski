import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Example {
    private void run() {
        JFrame window = createWindow();
        window.setVisible(true);
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame();
        frame.setTitle("Testing Stuff");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        String birdString = "Bird";
        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);
        constraints.gridy = 0;
        panel.add(birdButton, constraints);

        String catString = "Cat";
        JRadioButton catButton = new JRadioButton(catString);
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(catString);
        constraints.gridy = 1;
        panel.add(catButton, constraints);

        String dogString = "Dog";
        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand(dogString);
        constraints.gridy = 2;
        panel.add(dogButton, constraints);

        String rabbitString = "Rabbit";
        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand(rabbitString);
        constraints.gridy = 3;
        panel.add(rabbitButton, constraints);

        String pigString = "Pig";
        JRadioButton pigButton = new JRadioButton(pigString);
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand(pigString);
        constraints.gridy = 4;
        panel.add(pigButton, constraints);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        RadioActionListener listener = new RadioActionListener();

        //Register a listener for the radio buttons.
        birdButton.addActionListener(listener);
        catButton.addActionListener(listener);
        dogButton.addActionListener(listener);
        rabbitButton.addActionListener(listener);
        pigButton.addActionListener(listener);

        return panel;
    }

    private class RadioActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Example().run());
    }
}