public class ModelPane extends JPanel {

    private JTable table;

    public ModelPane(TableModel model) {
        setLayout(new BorderLayout());
        table = new JTable(model);
        add(new JScrollPane(table));
    }

}

public class ModelFrame extends JFrame {

    public ModelFrame(TableModel model) {
        setLayout(new BorderLayout());
        add(new ModelPane(model));
        pack();
        setLocationRelativeTo(null);
    }

}