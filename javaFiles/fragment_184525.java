class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
        private String title;

        public MyComboBoxRenderer(String newTitle) {
            title = newTitle;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
            if (index == -1 && value == null) setText(title );
            else setText(value.toString());
            return this;
        }
}