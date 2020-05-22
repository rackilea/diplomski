import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example {

    public static void main(String[] args){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new BorderLayout());
        TextField sampleField = new TextField();
        JLabel sampleLabel = new JLabel("sample text");
        panel.add(sampleField);
        sampleLabel.setLabelFor(sampleField);
        panel.add(sampleLabel,BorderLayout.NORTH);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}