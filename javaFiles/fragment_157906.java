public class StudentsTableModal extends AbstractTableModel {

       String[] columnNames = {"ID", "Firstname", "Secondname"};
       Class[] types = { Integer.class, String.class, String.class };
       private ArrayList<Student> data = new ArrayList<Student>();

        public ArrayList<Student> getData() {
            return data;
        }

        public void setData(ArrayList<Student> data) {
            this.data = data;
            fireTableDataChanged();
        }

        public int getRowCount() {
            return data.size();
        }

        public int getColumnCount() {
            return colNames.length;
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }       

        @Override
        public String getColumnName(int column) {
            return colNames[column];
        }

       @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Student s = data.get(rowIndex);
            switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getFirstname();

            case 2:
                return s.getSecondname();
            }
            return null;
        }
}