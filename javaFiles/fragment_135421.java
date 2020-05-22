class MyTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final List<Job> objects = new ArrayList<Job>();
    private final String[] columnNames = { "Nome Job", "Durata", "processed" };

    private final Class<?>[] metaModell = new Class[]{String.class, Integer.class, Boolean.class};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return objects.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        if (row >= objects.size()) 
            return null;
        Job job = getRow(row);
        switch (col) {
            case 0:
                return job.jobName;
            case 1:
                return job.time;
            case 2:
                return job.isProcessed();
        }
        return null;
    }

    private Job getRow(int row) {
        return objects.get(row);
    }

    @Override
    public Class<?> getColumnClass(int c) {
        if (c < metaModell.length)
            return metaModell[c];
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col >= 0 && col < columnNames.length;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Job job = getRow(row);
        switch (col) {
            case 0:
                job.jobName = (String) value;
                break;
            case 1:
                job.time = (Integer) value;
                break;
//          case 2:
//              job.processed = (Boolean) value;
//              break;
        }
        fireTableDataChanged();
    }

    public List<Job> getJobs() {
        return objects;
    }

    public void addRow(Job job) {
        this.objects.add(job);
        fireTableDataChanged();
    }
}