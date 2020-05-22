import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChessEg extends JPanel {
    private static final int IMG_W = 60;
    private static final int CELL_WIDTH = 80;
    private static final Color PIECE_COLOR = Color.RED.darker();
    private ChessBoardPanel chessBoardPanel = new ChessBoardPanel(CELL_WIDTH);
    private JLabel pieceLabel = new JLabel();

    public ChessEg() {
        ChessBrdPanelListener pieceListener = new ChessBrdPanelListener();
        chessBoardPanel.addMouseListener(pieceListener);
        chessBoardPanel.addMouseMotionListener(pieceListener);
        pieceLabel.setIcon(createPieceIcon());
        setLayout(new BorderLayout());
        add(chessBoardPanel, BorderLayout.CENTER);
        chessBoardPanel.getCellAt(1, 0).add(pieceLabel);
    }

    private Icon createPieceIcon() {
        BufferedImage img = new BufferedImage(IMG_W, IMG_W, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(PIECE_COLOR);
        g2.fillOval(2, 2, IMG_W - 4, IMG_W - 4);
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.DARK_GRAY);
        g2.drawOval(2, 2, IMG_W - 4, IMG_W - 4);
        g2.dispose();
        return new ImageIcon(img);
    }

    public boolean isNewChessCellValid(ChessCell newChessCell) {
        // right now, just checks if placing on a dark square
        // TODO: improve logic
        return ChessBoardPanel.DARK_COLOR.equals(newChessCell.getBackground());
    }

    private class ChessBrdPanelListener extends MouseAdapter {
        private JLabel label;
        private ChessCell originalChessCell;
        private JPanel glassPane;
        private Point gpP;
        private ChessCell newChessCell;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            JPanel src = (JPanel) e.getSource();
            Component comp = src.getComponentAt(e.getPoint());
            if (comp != null && ((JComponent) comp).getComponentCount() == 1) {
                originalChessCell = (ChessCell) comp;
                label = (JLabel) originalChessCell.getComponent(0);
            } else {
                return;
            }
            originalChessCell.remove(label);
            originalChessCell.revalidate();
            originalChessCell.repaint();
            glassPane = (JPanel) SwingUtilities.getRootPane(originalChessCell).getGlassPane();
            glassPane.setVisible(true);
            gpP = glassPane.getLocationOnScreen();
            glassPane.setLayout(null);
            int x = e.getXOnScreen() - gpP.x - label.getWidth() / 2;
            int y = e.getYOnScreen() - gpP.y - label.getHeight() / 2;
            label.setLocation(x, y);
            label.setSize(label.getPreferredSize());
            glassPane.add(label);
            glassPane.repaint();
            e.consume();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (label == null) {
                return;
            }
            int x = e.getXOnScreen() - gpP.x - label.getWidth() / 2;
            int y = e.getYOnScreen() - gpP.y - label.getHeight() / 2;
            label.setLocation(x, y);
            repaint();
            JPanel src = (JPanel) e.getSource();
            Component comp = src.getComponentAt(e.getPoint());
            if (comp != null) {
                newChessCell = (ChessCell) comp;
                if (isNewChessCellValid(newChessCell)) {
                    newChessCell.add(label);
                } else {
                    originalChessCell.add(label);
                }
            } else {
                originalChessCell.add(label);
            }


            label = null;
            glassPane.setVisible(false);
            revalidate();
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (label == null) {
                return;
            }
            int x = e.getXOnScreen() - gpP.x - label.getWidth() / 2;
            int y = e.getYOnScreen() - gpP.y - label.getHeight() / 2;
            label.setLocation(x, y);
            repaint();
        }
    }

    private static void createAndShowGui() {
        ChessEg mainPanel = new ChessEg();
        JFrame frame = new JFrame("Chess Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class ChessBoardPanel extends JPanel {
    public static final Color DARK_COLOR = new Color(180, 85, 0);
    public static final Color LIGHT_COLOR = new Color(220, 190, 160);
    private int cellWidth;
    private ChessCell[][] panelGrid = new ChessCell[8][8];

    public ChessBoardPanel(int cellWidth) {
        this.cellWidth = cellWidth;
        setLayout(new GridLayout(8, 8));
        for (int i = 0; i < panelGrid.length; i++) {
            for (int j = 0; j < panelGrid[i].length; j++) {
                char rank = (char) ('8' - i);
                char file = (char) ('a' + j);
                panelGrid[i][j] = new ChessCell(rank, file);
                panelGrid[i][j].setPreferredSize(new Dimension(cellWidth, cellWidth));
                Color bg = i % 2 == j % 2 ? LIGHT_COLOR : DARK_COLOR;
                panelGrid[i][j].setBackground(bg);
                add(panelGrid[i][j]);
            }
        }
    }

    public JPanel getCellAt(int i, int j) {
        return panelGrid[i][j];
    }

    public int getCellWidth() {
        return cellWidth;
    }
}

@SuppressWarnings("serial")
class ChessCell extends JPanel {
    private char rank;
    private char file;

    public ChessCell(char rank, char file) {
        super(new GridBagLayout());
        this.rank = rank;
        this.file = file;
    }

    public char getRank() {
        return rank;
    }

    public char getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "ChessCell [rank=" + rank + ", file=" + file + "]";
    }
}