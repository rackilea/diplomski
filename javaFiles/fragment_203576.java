class MyTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private ArrayList<Person1> personList = new ArrayList<Person1>();
    private String[] columnNames = { "First Name", "Last Name", "E-mail", "Telephone" };

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return personList.size(); //!! 
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person1 person = personList.get(row);
        switch (col) {
        case 0:
            return person.name;
        case 1:
            return person.surname;
        case 2:
            return person.mail;
        case 3: 
            return person.telephone;
        }
        return "";
    }

    public void setValueAt(String n, String s, String e, int t) {
        Person1 person = new Person1(n, s, e, t);
        personList.add(person);
        int firstRow = personList.size() - 1;
        int lastRow = firstRow;
        fireTableRowsInserted(firstRow, lastRow);
    }
}