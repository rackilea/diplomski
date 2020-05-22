import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ButtonSel extends JFrame implements ActionListener {
    JLabel  buttonSelLabel  = new JLabel("Choose Which Timer To Run");
    JButton pomoButton      = new JButton("00:25:00");
    JButton shrtButton      = new JButton("00:05:00");
    JButton longButton      = new JButton("00:30:00");
    JButton startButton     = new JButton("Go");
    JButton pauseButton     = new JButton("Pause");
    JButton quitButton      = new JButton("Quit");
    JLabel  textDisplay     = new JLabel("00:00:00");
    JPanel  timerPanel      = new JPanel();


    public ButtonSel() {
        super("ButtonTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timerPanel = new JPanel();
        timerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1.0D;
        c.weighty = 1.0D;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.insets = new Insets(10, 10, 0, 0);
        c.ipadx = 0;
        c.ipady = 0;
        buttonSelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerPanel.add(buttonSelLabel, c); // line 1

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        timerPanel.add(pomoButton, c); // line 2

        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        timerPanel.add(shrtButton, c);

        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 0, 10);
        timerPanel.add(longButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        c.insets = new Insets(10, 10, 0, 0);
        textDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        timerPanel.add(textDisplay, c); // line 3

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 0);
        timerPanel.add(startButton, c); // line 4

        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        timerPanel.add(pauseButton, c);

        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);
        timerPanel.add(quitButton, c);

        pomoButton.addActionListener(this);
        shrtButton.addActionListener(this);
        longButton.addActionListener(this);
        startButton.addActionListener(this);
        pauseButton.addActionListener(this);
        quitButton.addActionListener(this);

        this.add(timerPanel);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent radioSelect) {
        Object source = radioSelect.getSource();
        if (source == pomoButton)
            textDisplay.setText("00:25:00");
        else if (source == shrtButton)
            textDisplay.setText("00:05:00");
        else if (source == longButton)
            textDisplay.setText("00:30:00");
        else if (source == startButton)
            textDisplay.setText("Started");
        else if (source == pauseButton)
            textDisplay.setText("Paused");
        else if (source == quitButton)
            textDisplay.setText("Quit");
        else
            textDisplay.setText("00:00:00");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonSel();            
            }
        });
    }

}