import net.miginfocom.swing.MigLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableExample {

    private void run() {
        setUpWindow();
    }

    private void setUpWindow() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // frame.getContentPane().add(createNullPanel());
        // frame.getContentPane().add(createGridBagPanel());
        frame.getContentPane().add(createMigPanel());

        // If using null layout manager
        // frame.setSize(800, 800);

        // If using a none null layout manager
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Not recommended
    private JPanel createNullPanel() {
        JPanel nullPanel = new JPanel(null);

        String[] headers = {"Header 1", "Header 2", "etc..."};
        String[][] data = {{"Some data", "some more data", "etc..."},
                {"Some data 1", "some more data 3", "etc..."},
                {"Some data 2", "some more data 4", "etc..."}};

        JTable table = new JTable(data, headers);
        JScrollPane scrollableTable = new JScrollPane(table);

        scrollableTable.setMinimumSize(new Dimension(100, 100));
        scrollableTable.setMaximumSize(new Dimension(500, 500));

        JButton minButton = new JButton("Min");
        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollableTable.setSize(scrollableTable.getMinimumSize());
            }
        });
        minButton.setBounds(10, 10, 50, 25);
        nullPanel.add(minButton);


        JButton maxButton = new JButton("Min");
        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollableTable.setSize(scrollableTable.getMaximumSize());
            }
        });
        maxButton.setBounds(70, 10, 50, 25);
        nullPanel.add(maxButton);

        nullPanel.add(scrollableTable);
        scrollableTable.setBounds(10, 45, 300, 300);

        return nullPanel;
    }

    private JPanel createGridBagPanel() {
        JPanel gridBagPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);

        String[] headers = {"Header 1", "Header 2", "etc..."};
        String[][] data = {{"Some data", "some more data", "etc..."},
                {"Some data 1", "some more data 3", "etc..."},
                {"Some data 2", "some more data 4", "etc..."}};

        JTable table = new JTable(data, headers);
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setMinimumSize(new Dimension(400, 400));
        scrollableTable.setPreferredSize(new Dimension(500, 500));
        scrollableTable.setMaximumSize(new Dimension(800, 800));

        // Nasty work around to support min and max size
        // https://stackoverflow.com/questions/15161332/setting-up-a-maximum-component-size-when-using-gridbaglayout-in-java
        JPanel wrappingPanel = new JPanel(null);
        wrappingPanel.setLayout(new BoxLayout(wrappingPanel, BoxLayout.LINE_AXIS));
        wrappingPanel.add(scrollableTable);

        gridBagPanel.add(wrappingPanel, constraints);

        return gridBagPanel;
    }

    private JPanel createMigPanel() {
        String layoutConstraints = "fillx, filly";
        String columnAndRowConstraints = "fill, grow, center";

        JPanel migPanel = new JPanel(new MigLayout(layoutConstraints, columnAndRowConstraints, columnAndRowConstraints));

        String[] headers = {"Header 1", "Header 2", "etc..."};
        String[][] data = {{"Some data", "some more data", "etc..."},
                {"Some data 1", "some more data 3", "etc..."},
                {"Some data 2", "some more data 4", "etc..."}};

        JTable table = new JTable(data, headers);
        JScrollPane scrollableTable = new JScrollPane(table);

        migPanel.add(new JScrollPane(table), "width 400:500:800, height 400:500:800");

        return migPanel;
    }

    public static void main(String[] args) {
        JTableExample example = new JTableExample();
        example.run();
    }
}