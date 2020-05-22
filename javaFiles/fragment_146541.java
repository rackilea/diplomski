DefaultTableModel model = new DefaultTableModel() {
        String[] person = {"ID", "firstName", "LastName", "M.I", "Age", "Street", "City"};

        @Override
        public int getColumnCount() {
            return person.length;
        }

        @Override
        public String getColumnName(int index) {
            return person[index];
        }
    };