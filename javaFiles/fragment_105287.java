package calculator;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class KeyPanel extends JPanel  implements ActionListener {

    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    private TextPanel text;

    public KeyPanel(TextPanel text) {

        this.text = text;

        b1 = new JButton("0");

        b2 = new JButton("1");
        b3 = new JButton("2");
        b4 = new JButton("3");
        b5 = new JButton("4");
        b6 = new JButton("5");
        b7 = new JButton("6");
        b8 = new JButton("7");
        b9 = new JButton("8");
        b10 = new JButton("9");
        b11 = new JButton("+");
        b12 = new JButton("-");
        b13 = new JButton("*");
        b14 = new JButton("/");
        b15 = new JButton("C");
        b16 = new JButton("=");


        setLayout(new GridLayout(5, 5));

        add(b1, new GridLayout());
        add(b2, new GridLayout());
        add(b3, new GridLayout());
        add(b4, new GridLayout());
        add(b5, new GridLayout());
        add(b6, new GridLayout());
        add(b7, new GridLayout());
        add(b8, new GridLayout());
        add(b9, new GridLayout());
        add(b10, new GridLayout());
        add(b11, new GridLayout());
        add(b12, new GridLayout());
        add(b13, new GridLayout());
        add(b14, new GridLayout());
        add(b15, new GridLayout());
        add(b16, new GridLayout());

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String face = e.getActionCommand();
        System.out.println(face + " was clicked");
        text.write(face);
    }
}

package calculator;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

    private JTextArea textarea;

    TextPanel() {
        textarea = new JTextArea(5, 5);
        textarea.append("0");
        setLayout(new BorderLayout());
        add(new JScrollPane(textarea), BorderLayout.NORTH);
        textarea.setEditable(false);
    }

    public String getText() {
        return textarea.getText();
    }

    public void write(String text) {
        textarea.setText(text);
    }

}

package calculator;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class frame extends JFrame {

    private TextPanel txt;
    private KeyPanel key;

    frame() {
        setVisible(true);
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setName("Calc");

        setLayout(new BorderLayout());

        txt = new TextPanel();
        key = new KeyPanel(txt);

        add(txt, BorderLayout.NORTH);
        add(key, BorderLayout.CENTER);

    }

}