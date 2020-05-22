import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Foo extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 600;
    private JPanel gridPanel = new JPanel(new GridLayout(0, 1));
    public Foo() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("Add Panel") {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridPanel.add(createButtonPanel());
                gridPanel.revalidate();
                gridPanel.repaint();
            }
        }));

        JPanel borderLayoutPanel = new JPanel(new BorderLayout());
        borderLayoutPanel.add(gridPanel, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(borderLayoutPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setPreferredSize(new Dimension(PREF_W, PREF_H));
        setLayout(new BorderLayout());
        add(scrollPane);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    private JPanel createButtonPanel() {
        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;

        button = new JButton("Button 1");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Button 3");
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Long-Named Button 4");
        c.ipady = 40;     
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);
        return pane;
    }

    private static void createAndShowGui() {
        Foo mainPanel = new Foo();

        JFrame frame = new JFrame("Foo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}