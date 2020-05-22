package test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("test");

                JTextPane testPane = new JTextPane();
                testPane.setText("left\nright");

                StyledDocument doc = testPane.getStyledDocument();

                //left alignment
                SimpleAttributeSet myAttributeSet = new SimpleAttributeSet();
                StyleConstants.setAlignment(myAttributeSet, StyleConstants.ALIGN_LEFT);
                doc.setParagraphAttributes(0, 4, myAttributeSet, false);

                //right alignment
                StyleConstants.setAlignment(myAttributeSet, StyleConstants.ALIGN_RIGHT);
                doc.setParagraphAttributes(5, 9, myAttributeSet, false);

                frame.getContentPane().setLayout(new BorderLayout());
                frame.getContentPane().add(testPane,BorderLayout.CENTER);
                frame.setSize(200,200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}