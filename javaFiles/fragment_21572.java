import java.awt.*;
import javax.swing.*;

class LookOfDisabledButton {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel gui = new JPanel(new BorderLayout(3,3));
                JPanel pEnabled = new JPanel(new GridLayout(1,0,2,2));
                pEnabled.setBackground(Color.green);
                gui.add(pEnabled, BorderLayout.NORTH);

                JPanel pDisabled = new JPanel(new GridLayout(1,0,2,2));
                pDisabled.setBackground(Color.red);
                gui.add(pDisabled, BorderLayout.SOUTH);

                // tweak the Color of the Metal disabled button
                UIManager.put("Button.disabledText", new Color(40,40,255));

                UIManager.LookAndFeelInfo[] plafs = 
                    UIManager.getInstalledLookAndFeels();
                for (UIManager.LookAndFeelInfo plafInfo : plafs) {
                    try {
                        UIManager.setLookAndFeel(plafInfo.getClassName());
                        JButton bEnabled = new JButton(plafInfo.getName());
                        pEnabled.add(bEnabled);
                        JButton bDisabled = new JButton(plafInfo.getName());
                        bDisabled.setEnabled(false);
                        pDisabled.add(bDisabled);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }

                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}