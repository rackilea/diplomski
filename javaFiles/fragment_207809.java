JComboBox<JobTitle> jobCombo = new JComboBox<>(JobTitle.values());
jobCombo.setRenderer(new DefaultListCellRenderer() {

    public Component getListCellRendererComponent(JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        value = ((JobTitle) value).getName();
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }

});