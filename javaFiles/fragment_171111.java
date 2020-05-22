class MyTableCellEditor extends DefaultCellEditor {
        private DefaultCellEditor defaultEditor;
        private DefaultComboBoxModel nudaModel = new DefaultComboBoxModel(new String[] { "N", "U", "D", "A" });
        private DefaultComboBoxModel nahxpModel = new DefaultComboBoxModel(new String[] { "N", "A", "H", "X", "P" });

        public MyTableCellEditor() {
            super(new JComboBox());
            defaultEditor = new DefaultCellEditor(new JTextField());
        }

        private JComboBox getComboBox() {
            return (JComboBox) editorComponent;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            Membership top = _Memberships.get(column);
            Membership side = _Memberships.get(row);

            if (side.getId() == top.getId() && side.isEft() && top.isEft()) {
                return defaultEditor.getTableCellEditorComponent(table, value, isSelected, row, column);
            } else if (side.getId() != top.getId() && side.isEft() && top.isEft()) {
                getComboBox().setModel(nudaModel);
            } else {
                getComboBox().setModel(nahxpModel);
            }
            return super.getTableCellEditorComponent(table, NUHPADX(side.getId(), top.getId()), isSelected, row, column);
        }
    }