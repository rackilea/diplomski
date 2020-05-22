class SpielerBenennungTableModel implements TableModel {

    private int spielerAnzahl = 0;
    private ArrayList<TableModelListener> Listener = new ArrayList<TableModelListener>();

    // this will hold the data for every rows
    private List<String[]> rows;

    public SpielerBenennungTableModel(int spielerAnzahl){
        this.spielerAnzahl = spielerAnzahl;

        // initialize the list so that all rows are
        // ["Spieler: n", ""]
        rows = new ArrayList<>();
        for(int i = 0; i<spielerAnzahl; i++) {
            this.rows.add(new String[] { "Spieler: " + (i+1), "" });
        }
    }

    @Override
    public int getRowCount() {
        return spielerAnzahl;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        return col == 0 ? "Spieler" : "Eigener Name";
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return rows.get(row)[col];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        rows.get(row)[col] = value.toString();
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
        Listener.add(arg0);
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
        Listener.remove(arg0);
    }
}