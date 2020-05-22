import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonGroupFocusTraversalTest {
  public JComponent makeUI() {
    JPanel parent = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.gridx = 1;
    gbc.gridy = 1;
    parent.add(new JLabel("Start"), gbc);
    gbc.gridx++;
    parent.add(new JTextField(10), gbc);

    gbc.gridx = 1;
    gbc.gridy++;
    parent.add(new JLabel("End"), gbc);
    gbc.gridx++;
    JTextField textField = new JTextField(10);
    parent.add(textField, gbc);

    gbc.gridx = 1;
    gbc.gridy++;
    parent.add(new JLabel("Colors"), gbc);

    gbc.gridx++;
    final Box buttons = Box.createVerticalBox();
    parent.add(buttons, gbc);
    final ButtonGroup bg = new ButtonGroup();
    for (String s : "Red,Orange,Yellow,Green,Blue,Indigo,Violet".split(",")) {
      JRadioButton radioBtn = new JRadioButton(s);
      buttons.add(radioBtn);
      bg.add(radioBtn);
    }

    gbc.gridx = 1;
    gbc.gridy += 2;
    gbc.gridwidth = 2;
    final JLabel currentValue = new JLabel("none");
    parent.add(currentValue, gbc);
    gbc.gridy--;
    JButton btn = new JButton("Show Button Group Value");
    parent.add(btn, gbc);

    buttons.setFocusTraversalPolicyProvider(true);
    buttons.setFocusTraversalPolicy(new LayoutFocusTraversalPolicy() {
      @Override public Component getDefaultComponent(Container focusCycleRoot) {
        ButtonModel selection = bg.getSelection();
        for (Component c: focusCycleRoot.getComponents()) {
          JRadioButton radioBtn = (JRadioButton) c;
          ButtonModel loopModel = radioBtn.getModel();
          if (loopModel == selection) {
            return radioBtn;
          }
        }
        return super.getDefaultComponent(focusCycleRoot);
      }
    });
    return parent;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ButtonGroupFocusTraversalTest().makeUI());
      f.setSize(320, 320);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}