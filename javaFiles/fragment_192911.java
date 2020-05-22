import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class AutoSaveForm {

    private JComponent ui = null;

    AutoSaveForm() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(6, 4));
        JPanel labels = new JPanel(new GridLayout(0, 1, 4, 4));
        ui.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0, 1, 4, 4));
        ui.add(fields);
        for (int ii = 1; ii < 16; ii++) {
            JLabel l = new JLabel("Field " + ii);
            JTextField tf = new JTextField(20);
            l.setLabelFor(tf);
            labels.add(l);
            fields.add(tf);
        }
        ui.setBorder(new EmptyBorder(8, 8, 8, 8));
        restoreFields();
    }

    public JComponent getUI() {
        return ui;
    }

    protected final void restoreFields() {
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        getLabels(ui, labels);
        File f = getPropertiesFile();
        Properties prop = new Properties();
        try {
            FileReader fr = new FileReader(f);
            prop.load(fr);
            // restore the values
            for (JLabel label : labels) {
                String value = prop.getProperty(label.getText());
                Component c = label.getLabelFor();
                JTextField tf = (JTextField) c;
                tf.setText(value);
            }
        } catch (FileNotFoundException ex) {
            // proper exception handling & clean up left to user
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected final void saveFields() {
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        getLabels(ui, labels);
        Properties prop = new Properties();
        // populate the properties file
        for (JLabel label : labels) {
            Component c = label.getLabelFor();
            JTextField tf = (JTextField) c;
            prop.put(label.getText(), tf.getText());
        }
        File f = getPropertiesFile();
        try {
            // proper exception handling & clean up left to user
            FileWriter fw = new FileWriter(f);
            prop.store(fw, "Field values of the form");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Provide a file that is reproducible and writable & readable.
     */
    private final File getPropertiesFile() {
        File f = new File(System.getProperty("user.home"));
        f = new File(f, "java");
        f = new File(f, "formfields.prop");
        return f;
    }

    /**
     * A recursive method call to get all labels in a container.
     */
    private final void getLabels(Container c, ArrayList<JLabel> labels) {
        Component[] components = c.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel l = (JLabel) component;
                labels.add(l);
            } else if (component instanceof Container) {
                Container container = (Container) component;
                getLabels(container, labels);
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                AutoSaveForm o = new AutoSaveForm();

                JFrame f = new JFrame("Auto Save Form");
                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                f.addWindowListener(new SaveListener(o, f));
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

class SaveListener extends WindowAdapter {

    private AutoSaveForm form;
    private JFrame frame;

    public SaveListener(AutoSaveForm form, JFrame frame) {
        this.form = form;
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        form.saveFields();
        frame.dispose();
    }
}