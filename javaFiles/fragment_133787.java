import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JComboBoxDemo implements Runnable
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new JComboBoxDemo());
  }

  public void run()
  {    
    JComboBox comboBox = new JComboBox(new String[]{"A", "B", "C"});
    comboBox.setEditable(true);

    final JTextField editorComponent = (JTextField) comboBox.getEditor().getEditorComponent();
    editorComponent.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        editorComponent.transferFocus();
      }
    });

    JPanel panel = new JPanel(new FlowLayout());
    panel.add(new JLabel("Field 1"));
    panel.add(comboBox);
    panel.add(new JLabel("Field 2"));
    panel.add(new JTextField(10));
    panel.add(new JLabel("Field 3"));
    panel.add(new JTextField(10));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    Container c = frame.getContentPane();
    c.setLayout(new BorderLayout());
    c.add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
}