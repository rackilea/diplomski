public class TableWrapperPanel extends JPanel {
    private Table table;
    public TableWrapperPanel(Table table) {
        setLayout(new BorderLayout());
        this.table = table;
        add(table);
    }

    public Dimension getPreferredSize() {
        cvars = CVarList.getInstance();
        return new Dimension(cvars.get("Window", "width", int.class, 800),
            cvars.get("Window", "height", int.class, 600));
    }
}