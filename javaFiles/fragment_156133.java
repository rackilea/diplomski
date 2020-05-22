import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;

class ShowPreviews {

    class ToolTipListener extends MouseAdapter {

        JWindow toolTip;
        JLabel label;
        Component preview;

        ToolTipListener(Component preview) {
            this.preview = preview;
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if (toolTip==null) {
                toolTip = new JWindow();
                label = new JLabel();
                toolTip.add(label);
            }
            label.setIcon( new ImageIcon(
                getScaledImageOfComponent(preview, .6) ) );
            toolTip.pack();
            Component c = (Component)me.getSource();
            int x = c.getLocationOnScreen().x+(c.getWidth()/2);
            int y = c.getLocationOnScreen().y+c.getHeight();

            toolTip.setLocation(x,y);
            toolTip.setVisible(true);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            toolTip.setVisible(false);
            toolTip.dispose();
        }

        public Image getScaledImageOfComponent(
            Component component, double scale) {
            BufferedImage bi = new BufferedImage(
                (int)(component.getWidth()*scale),
                (int)(component.getHeight()*scale),
                BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bi.createGraphics();
            g.scale(scale, scale);
            component.paint(g);
            g.dispose();

            return bi;
        }
    }

    ShowPreviews() {
        JPanel gui = new JPanel(new BorderLayout(2,2));

        final CardLayout cards = new CardLayout();
        final JPanel cardPanel = new JPanel(cards);

        JPanel treePanel = new JPanel();
        JTree tree = new JTree();
        tree.setVisibleRowCount(5);
        tree.expandRow(2);
        treePanel.add(new JScrollPane(tree));
        cardPanel.add(treePanel, "tree");

        JPanel labelPanel = new JPanel(new GridLayout(0,1,2,2));
        for (int ii=1; ii<7; ii++) {
            labelPanel.add(new JLabel("Label " + ii));
        }
        cardPanel.add(new JScrollPane(labelPanel), "label");

        JToolBar uiSelectors = new JToolBar();
        // we should use a ButtonGroup for the cards,
        // but plain buttons look better on hover.
        JButton treeButton = new JButton("Tree");
        treeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                cards.show(cardPanel, "tree");
            }
        });
        uiSelectors.add(treeButton);

        treeButton.addMouseListener( new ToolTipListener(treePanel));

        JButton labelButton = new JButton("Label");
        labelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                cards.show(cardPanel, "label");
            }
        });
        uiSelectors.add(labelButton);

        labelButton.addMouseListener( new ToolTipListener(labelPanel));

        gui.add(uiSelectors, BorderLayout.NORTH);
        gui.add(cardPanel, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, gui);
    }

    public static void main(String[] args) {
        // start the GUI on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowPreviews();
            }
        });
    }
}