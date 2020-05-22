import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicListUI;

public class TJFileChooserDemo {

    //Obtains the (first) JList which is found inside the component/container:
    public static JList getFirstJList(final Component component) {
        if (component instanceof JList)
            return (JList) component;
        if (component instanceof Container)
            for (int i=0; i<((Container)component).getComponentCount(); ++i) {
                final JList list = getFirstJList(((Container)component).getComponent(i));
                if (list != null)
                    return list;
            }
        return null;
        //As you can see, it's a bit lazy hack, which has to run for every JFileChooser once at start-up.
    }

    private static final double SCALE_STEP_SIZE = 0.125; //Smaller values of this makes zooming slower. Greater values makes zooming faster.
    private static double scaleFactor = 1;

    public static class TJListCellRenderer extends DefaultListCellRenderer {
        public TJListCellRenderer() {
            //Ensure every pixel is painted starting from the top-left corner of the label:
            super.setVerticalAlignment(JLabel.TOP);
            super.setHorizontalAlignment(JLabel.LEFT);
            //We need to do this, because the scaling in paintComponent() is also relative to the top-left corner.
        }

        @Override
        public void paintComponent(final Graphics g) {
            //setRenderingHints here? Probably for ANTIALIAS...
            ((Graphics2D)g).scale(scaleFactor, scaleFactor); //Let's scale everything that is painted afterwards:
            super.paintComponent(g); //Let's paint the (scaled) JLabel!
        }

        @Override
        public Dimension getPreferredSize() {
            final Dimension superPrefDim = super.getPreferredSize(); //Handles automatically insets, icon size, text font, etc.
            final double w = superPrefDim.width * scaleFactor, //And we just scale the preferred size.
                         h = superPrefDim.height * scaleFactor; //And we just scale the preferred size.
            return new Dimension((int)w + 5, (int)h + 5); //Add 5 extra pixels to spare.
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//            System.out.println(value.getClass()); //Something ugly...
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }

    public static class TJListUI extends BasicListUI {
        @Override
        public void updateLayoutState() {
            super.updateLayoutState(); //Just make the following method public.
            /*Note: this is not really needed here:
            The method could remain protected, but in the case you want this
            code to be a bit more reusable, then you shall make it public.*/
        }
    }

    public static void main(final String[] args) {
        final JFileChooser jfc = new JFileChooser();
        jfc.setDialogType(JFileChooser.OPEN_DIALOG);

        final TJListUI ui = new TJListUI();

        final JList list = getFirstJList(jfc);
        list.setUI(ui);
        list.setCellRenderer(new TJListCellRenderer());

        final JButton buttonZoomIn = new JButton("Zoom in"),
                      buttonZoomOut = new JButton("Zoom out"),
                      buttonResetZoom = new JButton("Reset zoom");

        buttonZoomIn.addActionListener(e -> {
            scaleFactor = scaleFactor + SCALE_STEP_SIZE;
            ui.updateLayoutState(); //Read the preferred sizes from the cell renderer.
            list.revalidate(); //Update the JScrollPane.
            list.repaint(); //Repaint the list.
        });

        buttonZoomOut.addActionListener(e -> {
            scaleFactor = Math.max(scaleFactor - SCALE_STEP_SIZE, SCALE_STEP_SIZE); //Do not allow underflow.
            ui.updateLayoutState(); //Read the preferred sizes from the cell renderer.
            list.revalidate(); //Update the JScrollPane.
            list.repaint(); //Repaint the list.
        });

        buttonResetZoom.addActionListener(e -> {
            scaleFactor = 1;
            ui.updateLayoutState(); //Read the preferred sizes from the cell renderer.
            list.revalidate(); //Update the JScrollPane.
            list.repaint(); //Repaint the list.
        });

        final JPanel buttons = new JPanel(); //FlowLayout.
        buttons.add(buttonZoomIn);
        buttons.add(buttonZoomOut);
        buttons.add(buttonResetZoom);

        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(buttons, BorderLayout.PAGE_START);
        panel.add(jfc, BorderLayout.CENTER);

        final JFrame frame = new JFrame("JFileChooser's JList cell sizes demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}