import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class SelectionTest extends KeyAdapter
{
    final JTextArea jTextArea;
    public static void main(String[] args)
    {
        new SelectionTest();
    }

    SelectionTest()
    {
        JFrame jFrame=new JFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTextArea = new JTextArea("Test 1-2-3");

        Action someAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jTextArea.selectAll();
            }
        };
        jTextArea.getInputMap().put(
                KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "someAction");
        jTextArea.getActionMap().put("someAction", someAction);

        jFrame.add(jTextArea);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}