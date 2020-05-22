class Frame extends JFrame implements FlowListener {
    private JTable table;
    ...

    public Frame() {
        ...
        TableModel tableModel = new TableModel(m_rows);  // Did you mean DefaultTableModel?
        table = new JTable(tableModel);
        ...
    }

    @Override
    public void updateOnFlow(List<Candle> newFlow) {
        m_rows = newFlow;
        TableModel tableModel = new TableModel(m_rows);
        table.setModel(tableModel);
        this.repaint();
    }
}