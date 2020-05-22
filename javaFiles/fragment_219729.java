import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Vector;

public class FontCheck {

    private JComponent ui = null;

    private final String text = "\uD83C\uDF2D"; 
    private JComboBox fontComboBox;
    private JTextField outputField = new JTextField(text, 5);

    FontCheck() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        ui.add(outputField);
        ui.add(getToolBar(), BorderLayout.PAGE_START);

        refreshFont();
    }

    private JToolBar getToolBar() {
        JToolBar tb = new JToolBar();
        tb.setLayout(new FlowLayout());

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();
        System.out.println(fonts.length + " font families installed");
        Vector<String> supportedFonts = new Vector<>();
        for (String fontName : fonts) {
            Font f = new Font(fontName, Font.PLAIN, 1);
            if (f.canDisplayUpTo(text)<0) {
                System.out.println(fontName);
                supportedFonts.add(fontName);
            }
        }
        fontComboBox = new JComboBox(supportedFonts);
        ActionListener refreshListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refreshFont();
            }
        };
        fontComboBox.addActionListener(refreshListener);

        tb.add(fontComboBox);
        return tb;
    }

    private void refreshFont() {
        String fontName = fontComboBox.getSelectedItem().toString();
        Font f = new Font(fontName, Font.PLAIN, 60);
        outputField.setFont(f);
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
                FontCheck o = new FontCheck();

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