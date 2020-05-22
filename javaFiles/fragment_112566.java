import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

public class MyScrollBarUI extends BasicScrollBarUI {

    protected static void initUI() {
        JFrame frame = new JFrame("Test scrollbar UI");
        JTable table = new JTable(new DefaultTableModel(30, 5));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        frame.add(scrollPane);
        frame.pack();
        frame.setSize(frame.getWidth(), frame.getHeight()-50); // Forces the vertical scroll bar to show up
        frame.setVisible(true);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(Color.black);
        g.fillRect(trackBounds.width / 2, trackBounds.y, 3, trackBounds.height);
        if (this.trackHighlight == BasicScrollBarUI.DECREASE_HIGHLIGHT) {
            this.paintDecreaseHighlight(g);
        } else if (this.trackHighlight == BasicScrollBarUI.INCREASE_HIGHLIGHT) {
            this.paintIncreaseHighlight(g);
        }
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !this.scrollbar.isEnabled()) {
            return;
        }
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(this.thumbDarkShadowColor);
        g.drawOval(2, 0, 14, 14);
        g.setColor(this.thumbColor);
        g.fillOval(2, 0, 14, 14);
        g.setColor(this.thumbHighlightColor);
        g.setColor(this.thumbLightShadowColor);
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initUI();
            };
        });
    }

}