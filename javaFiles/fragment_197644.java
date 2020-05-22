import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            DefaultListModel<String> model = new DefaultListModel<>();
            model.addElement("Apples");
            model.addElement("Bananas");
            model.addElement("Peachs");
            model.addElement("Pears");
            JList<String> listOfStrings = new JList<>(model);
            listOfStrings.setCellRenderer(new FancyPancyListCellRenderer());
            add(new JScrollPane(listOfStrings));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public static class FancyPancyListCellRenderer  extends DefaultListCellRenderer {

        protected static final Font SELECTED_FONT = new Font("Comic Sans MS", Font.PLAIN, 12);

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                setForeground(Color.YELLOW);
                setFont(SELECTED_FONT);
            } else {
                setFont(UIManager.getFont("Label.font"));
            }
            return this;

        }

    }

}