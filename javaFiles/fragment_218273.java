import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextPanePerfectSize extends JFrame
{
    JTextField textField;
    JTextPane textPane;

    public TextPanePerfectSize()
    {
        textField = new JTextField(20);
        textField.setText("add text");
        getContentPane().add(textField, BorderLayout.NORTH );
        textField.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Document doc = textPane.getDocument();
                    doc.insertString(doc.getLength(), " " + textField.getText(), null);
                    textField.setText("");
                    Dimension d = textPane.getPreferredSize();
                    Rectangle r = textPane.modelToView( textPane.getDocument().getLength() );
                    d.height = r.y + r.height;
                    textPane.setPreferredSize( d );
                    getContentPane().validate();
//                  pack();
                }
                catch(Exception e2) {}
            }
        });

        JLabel label = new JLabel("Hit Enter to Add Text to Text Pane");
        getContentPane().add(label);

        JPanel south = new JPanel();
        textPane = new JTextPane();
        textPane.setText("Some text");
        textPane.setEditable( false );
//      textPane.setPreferredSize( new Dimension(120, 23) );

        south.add( textPane );
//      getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(textPane, BorderLayout.SOUTH);
    }

    public static void main(String[] args)
    {
        JFrame frame = new TextPanePerfectSize();
        frame.setSize(200, 200);
        frame.setLocationRelativeTo( null );
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}