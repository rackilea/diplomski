public class MyTableModel extends AbstractTableModel implements TableModel {
    private List<Data> inclomeList;
    private List<Data> expenseList;

    private void setData(List<Data> list, Data data) {
        int rows = getRowCount();
        int row = list.size();
        list.add(data);

        if(row < rows) {
            fireTableRowsUpdated(row, row);
        }
        else {
            fireTableRowsInserted(row, row);
        }
    }

    public void setIncomeData(Data data) {
        if(inclomeList == null) {
            inclomeList = new ArrayList<>();
        }

        setData(inclomeList, data);
    }

    public void setExpenseData(Data data) {
        if(expenseList == null) {
            expenseList = new ArrayList<>();
        }

        setData(expenseList, data);
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
            case 3:
                return "Date";

            case 1: return "Income";
            case 4: return "Expenses";


            case 2:
            case 5:
                return "Amount";

            default:
                return super.getColumnName(column);
        }
    }

    @Override
    public int getRowCount() {
        if(inclomeList == null || expenseList == null) {
            if(inclomeList != null) {
                return inclomeList.size();
            }
            else if(expenseList != null) {
                return expenseList.size();
            }

            return 0;
        }

        return Math.max(inclomeList.size(), expenseList.size());
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Data inclome = null;
        Data expense = null;

        if(inclomeList != null && inclomeList.size() > row) {
            inclome = inclomeList.get(row);
        }

        if(expenseList != null && expenseList.size() > row) {
            expense = expenseList.get(row);
        }

        switch (column) {
            case 0: return inclome != null ? inclome.getDate() : "";
            case 1: return inclome != null ? inclome.getName() : "";
            case 2: return inclome != null ? inclome.getAmount() : "";
            case 3: return expense != null ? expense.getDate() : "";
            case 4: return expense != null ? expense.getName() : "";
            case 5: return expense != null ? expense.getAmount() : "";
        }

        return null;
    }

    public void update() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Database database = new Database();
                inclomeList = database.getData(Database.TBL_INCOME);
                expenseList = database.getData(Database.TBL_EXPENSES);

                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    fireTableDataChanged();
                }
                catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        worker.execute();
    }
}