import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class MyComboBox {

    private Vector<String> listSomeString = new Vector<String>();
    private JComboBox someComboBox = new JComboBox(listSomeString);
    private JComboBox editableComboBox = new JComboBox(listSomeString);
    private JComboBox non_EditableComboBox = new JComboBox(listSomeString);
    private JFrame frame;

    public MyComboBox() {
        listSomeString.add("-");
        listSomeString.add("Snowboarding");
        listSomeString.add("Rowing");
        listSomeString.add("Knitting");
        listSomeString.add("Speed reading");
        someComboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        someComboBox.setFont(new Font("Serif", Font.BOLD, 16));
        someComboBox.setEditable(true);
        someComboBox.getEditor().getEditorComponent().setBackground(Color.YELLOW);
        ((JTextField) someComboBox.getEditor().getEditorComponent()).setBackground(Color.YELLOW);
        editableComboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        editableComboBox.setFont(new Font("Serif", Font.BOLD, 16));
        editableComboBox.setEditable(true);
        JTextField text = ((JTextField) editableComboBox.getEditor().getEditorComponent());
        text.setBackground(Color.YELLOW);
        /*JComboBox coloredArrowsCombo = editableComboBox;
         Component[] comp = coloredArrowsCombo.getComponents();
         for (int i = 0; i < comp.length; i++) {
         if (comp[i] instanceof MetalComboBoxButton) {
         MetalComboBoxButton coloredArrowsButton = (MetalComboBoxButton) comp[i];
         coloredArrowsButton.setBackground(null);
         break;
         }
         }*/
        non_EditableComboBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        non_EditableComboBox.setFont(new Font("Serif", Font.BOLD, 16));
        frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1, 10, 10));
        frame.add(someComboBox);
        frame.add(editableComboBox);
        frame.add(non_EditableComboBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                    UIManager.getLookAndFeelDefaults().put("ComboBox[Enabled].backgroundPainter",
                            new javax.swing.plaf.nimbus.AbstractRegionPainter() {
                        @Override
                        protected AbstractRegionPainter.PaintContext getPaintContext() {
                            return new AbstractRegionPainter.PaintContext(null, null, false);
                        }

                        @Override
                        protected void doPaint(Graphics2D g, JComponent c,
                                int width, int height, Object[] extendedCacheKeys) {
                            g.setColor(Color.MAGENTA);
                            g.fill(new Rectangle(0, 0, width, height));
                        }
                    });
                    UIManager.getLookAndFeelDefaults().put("ComboBox[Focused+Pressed].backgroundPainter",
                            new javax.swing.plaf.nimbus.AbstractRegionPainter() {
                        @Override
                        protected AbstractRegionPainter.PaintContext getPaintContext() {
                            return new AbstractRegionPainter.PaintContext(null, null, false);
                        }

                        @Override
                        protected void doPaint(Graphics2D g, JComponent c,
                                int width, int height, Object[] extendedCacheKeys) {
                            g.setColor(Color.CYAN);
                            g.fill(new Rectangle(0, 0, width, height));
                        }
                    });
                    UIManager.getLookAndFeelDefaults().put("ComboBox[Focused].backgroundPainter",
                            new javax.swing.plaf.nimbus.AbstractRegionPainter() {
                        @Override
                        protected AbstractRegionPainter.PaintContext getPaintContext() {
                            return new AbstractRegionPainter.PaintContext(null, null, false);
                        }

                        @Override
                        protected void doPaint(Graphics2D g, JComponent c,
                                int width, int height, Object[] extendedCacheKeys) {
                            g.setColor(Color.RED);
                            g.fill(new Rectangle(0, 0, width, height));
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyComboBox aCTF = new MyComboBox();
            }
        });
    }
}