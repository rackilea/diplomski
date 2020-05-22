import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JPanel content = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(200, 200);
                    }
                };

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(content);
                frame.add(new FriendsPanel(), BorderLayout.EAST);
                frame.add(new MessagePane(), BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class FriendsPanel extends JPanel {

        public FriendsPanel() {
            setLayout(new BorderLayout());
            JLabel header = new JLabel("Social Pane");
            header.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(8, 8, 8, 8)));
            add(header, BorderLayout.NORTH);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("");
            model.addColumn("");

            model.addRow(new Object[]{"er3107", "Offline"});
            model.addRow(new Object[]{"er4360", "Online"});
            model.addRow(new Object[]{"er187", "Offline"});
            model.addRow(new Object[]{"er1040", "Online"});
            model.addRow(new Object[]{"er427", "Online"});
            model.addRow(new Object[]{"er4140", "Online"});
            model.addRow(new Object[]{"er835", "Offline"});
            model.addRow(new Object[]{"er2045", "Online"});
            model.addRow(new Object[]{"er4525", "Online"});
            model.addRow(new Object[]{"er4864", "Offline"});

            JTable table = new JTable(model);
            table.setPreferredScrollableViewportSize(new Dimension(100, 200));
            table.setFillsViewportHeight(true);

            Font font = table.getFont();
            FontMetrics fm = table.getFontMetrics(font);

            TableColumnModel cm = table.getColumnModel();
            TableColumn column = cm.getColumn(0);
            int width = fm.stringWidth("M") * 8;
            column.setWidth(width);
            column.setMaxWidth(width);
            column.setMinWidth(width);
            column.setPreferredWidth(width);

            column = cm.getColumn(1);
            column.setPreferredWidth(width);

            add(new JScrollPane(table));

            JButton btnF = new JButton("F");
            JButton btnI = new JButton("I");

            JPanel buttons = new JPanel();
            buttons.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(8, 8, 8, 8)));
            buttons.add(btnF);
            buttons.add(btnI);
            add(buttons, BorderLayout.SOUTH);
        }

    }

    public class MessagePane extends JPanel {

        public MessagePane() {
            setLayout(new BorderLayout());

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("");
            model.addColumn("");
            model.addColumn("");

            model.addRow(new Object[]{"rank", "user4916", "..."});
            model.addRow(new Object[]{"rank", "user2916", "..."});
            model.addRow(new Object[]{"rank", "user4471", "..."});
            model.addRow(new Object[]{"rank", "user4161", "..."});
            model.addRow(new Object[]{"rank", "user2048", "..."});
            model.addRow(new Object[]{"rank", "user3212", "..."});
            model.addRow(new Object[]{"Admin", "Chris", "Testing..."});

            JTable table = new JTable(model);
            table.setFillsViewportHeight(true);

            Font font = table.getFont();
            FontMetrics fm = table.getFontMetrics(font);

            table.setPreferredScrollableViewportSize(new Dimension(200, fm.getHeight() * 9));

            TableColumnModel cm = table.getColumnModel();
            TableColumn column = cm.getColumn(0);
            int width = fm.stringWidth("M") * 6;
            column.setWidth(width);
            column.setMaxWidth(width);
            column.setMinWidth(width);
            column.setPreferredWidth(width);

            width = fm.stringWidth("M") * 10;
            column = cm.getColumn(1);
            column.setWidth(width);
            column.setMaxWidth(width);
            column.setMinWidth(width);
            column.setPreferredWidth(width);

            add(new JScrollPane(table));

            JPanel buttons = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            buttons.add(new JTextField(5), gbc);
            gbc.gridx++;
            gbc.weightx = 0;
            buttons.add(new JButton("Send Chat"), gbc);
            add(buttons, BorderLayout.SOUTH);
        }

    }

}