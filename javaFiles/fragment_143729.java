import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EditableTitledBorder {

    private JComponent ui = null;
    private TitledBorder titledBorder;

    EditableTitledBorder() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        String initialTitle = "Dark Image";
        titledBorder = new TitledBorder(initialTitle);
        ui.setBorder(titledBorder);
        final JTextField titleField = new JTextField(initialTitle);
        ActionListener changeTitleListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                titledBorder.setTitle(titleField.getText());
                ui.repaint();
            }
        };
        titleField.addActionListener(changeTitleListener);
        ui.add(titleField, BorderLayout.PAGE_START);
        ui.add(new JLabel(new ImageIcon(
                new BufferedImage(200,40,BufferedImage.TYPE_INT_RGB))));
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                EditableTitledBorder o = new EditableTitledBorder();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}