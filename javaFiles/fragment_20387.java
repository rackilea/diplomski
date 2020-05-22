public class Example {

        public static void main(String [] a) {
            JFrame f = new JFrame();

            JPanel p = new JPanel();

            List<Acronym> acronyms = new ArrayList<Acronym>();
            acronyms.add(new Acronym("FBI", "Federal Bureau of Investigation"));
            acronyms.add(new Acronym("CIA", "Central Intelligence Agency"));

            final TableModel tModel = new AcronymTableModel(acronyms);

            JTable t = new JTable(tModel);
            t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    Acronym a = (Acronym)tModel.getValueAt(e.getFirstIndex(), 0);
                    System.out.println(a.acronym + ": " + a.definition);
                }});

            p.add(t);

            f.getContentPane().add(p);

            f.pack();

            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            f.setVisible(true);
        }


    }
    class Acronym {
        String acronym;
        String definition;

        public Acronym(String a, String d) {
            acronym = a;
            definition = d;
        }
    }
    class AcronymTableModel implements TableModel {

        private List<Acronym> acronyms;

        public AcronymTableModel(List<Acronym> acs) {
            this.acronyms = new ArrayList<Acronym>(acs);
        }

        @Override
        public int getRowCount() {
            return this.acronyms.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch(columnIndex) {
            case 0:
                return "Acronym";
            case 1:
                return "Definition";
            }

            return null;

        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class; // Since both columns are simply
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return acronyms.get(rowIndex);
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }
    }