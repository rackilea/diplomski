import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

@SuppressWarnings("serial")
public class DirectoryExplorer extends JFrame {
    private DirectoryExplorer() {
        super("Directory Explorer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        createPanel();
        setSize(800,600);
        setVisible(true);
    }

    private void createPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JTree tree = new JTree();

        paintRenderer pR = new paintRenderer();
        tree.setCellRenderer(pR);

        panel.add(new JScrollPane(tree));
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new DirectoryExplorer());
    }

    private class paintRenderer extends DefaultTreeCellRenderer {
        @Override
        public void paintComponent(Graphics g) {
            Color bColor;

            if (selected) {
                bColor = Color.RED;
            } else {
                bColor = getBackgroundNonSelectionColor();
                if (bColor == null) {
                    bColor = getBackground();
                }
            }

            int imageOffset = -1;
            if (bColor != null) {
                imageOffset = getLabelStart();
                g.setColor(bColor);
                if(getComponentOrientation().isLeftToRight()) {
                    g.fillRect(imageOffset, 0, getWidth() - imageOffset, getHeight());
                } else {
                    g.fillRect(0, 0, getWidth() - imageOffset, getHeight());
                }
            }

            if (hasFocus) {
                if (imageOffset == -1) {
                    imageOffset = getLabelStart();
                }

                if(getComponentOrientation().isLeftToRight()) {
                    paintFocus(g, imageOffset, 0, getWidth() - imageOffset, getHeight());
                } else {
                    paintFocus(g, 0, 0, getWidth() - imageOffset, getHeight());
                }
            }
            super.paintComponent(g);
        }

        private void paintFocus(Graphics g, int x, int y, int w, int h) {
            Color bsColor = Color.RED;

            if (bsColor != null && selected) {
                g.setColor(bsColor);
                g.drawRect(x, y, w - 1, h - 1);
            }
        }

        private int getLabelStart() {
            Icon currentI = getIcon();
            if(currentI != null && getText() != null) {
                return currentI.getIconWidth() + Math.max(0, getIconTextGap() - 1);
            }
            return 0;
        }
    }
}