import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest {

    public class DropDownPanel extends JPanel implements ActionListener,
            MouseListener {
        private static final long serialVersionUID = 1L;
        //protected JPanel header = new JPanel();
        protected JLabel titleLabel;
        protected Component content;
        protected boolean isExpanded = true;

        public DropDownPanel(String title, Component c) {
            content = c;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            titleLabel = new JLabel(title);
            //header.setLayout(new BorderLayout());
            //header.add(titleLabel, BorderLayout.NORTH);
            add(titleLabel);
            add(content);
            //header.addMouseListener(this);
            titleLabel.addMouseListener(this);
            apply();
        }

        public void toggleExpanded() {
            isExpanded = !isExpanded;
            apply();
        }

        protected void apply() {
            titleLabel.setText("Drop state: "
                    + (isExpanded ? "Expanded" : "Collapsed"));
            content.setVisible(isExpanded);
            //setMaximumSize(new Dimension(1024, getPreferredSize().height));
            invalidate();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            toggleExpanded();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            toggleExpanded();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public void run() {
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        Box box = Box.createVerticalBox();
        p.setLayout(new BorderLayout());
        final JTable table = new JTable();
        table.setFocusable(false);
        table.setFillsViewportHeight(true);
        table.setBackground(Color.white);
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        m.addColumn("Color");
        JButton b = new JButton("Remove row");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
                table.invalidate();
            }
        });
        JButton b2 = new JButton("Add row");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ((DefaultTableModel) table.getModel())
                        .addRow(new Object[] { "Red" });
                table.invalidate();
            }
        });
        DropDownPanel ddp = new DropDownPanel("Title", table);
        ddp.setAlignmentX(0);
        ddp.setAlignmentY(0);
        box.add(ddp);
        // ---------------------------------------------------------------
        // Without this line, it does not work; with this line, it is fine
        // box.add(new JPanel());
        // ---------------------------------------------------------------
        JLabel lll = new JLabel("End of Story");
        lll.setAlignmentX(0);
        lll.setAlignmentY(0);
        box.add(lll);
        p.add(new JScrollPane(box), BorderLayout.CENTER);
        p.add(b, BorderLayout.SOUTH);
        p.add(b2, BorderLayout.NORTH);
        f.add(p);
        ((DefaultTableModel) table.getModel()).addRow(new Object[] { "Red" });
        ((DefaultTableModel) table.getModel()).addRow(new Object[] { "Red" });
        ((DefaultTableModel) table.getModel()).addRow(new Object[] { "Red" });
        ((DefaultTableModel) table.getModel()).addRow(new Object[] { "Red" });
        ((DefaultTableModel) table.getModel()).addRow(new Object[] { "Red" });
        f.pack();
        f.setVisible(true);
        f.setSize(new Dimension(600, 400));
    }

    public static void main(String[] args) {
        new TableTest().run();
    }
}