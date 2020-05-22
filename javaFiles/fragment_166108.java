@Override
    public void updateId(String id) {
        boolean old = notify;
        notify = false;
        comboBox.setEditable(true);

        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
        int selectedIndex = comboBox.getSelectedIndex();
        model.removeElementAt(selectedIndex);
        model.insertElementAt(id, selectedIndex);
        comboBox.setSelectedIndex(selectedIndex);

        comboBox.setEditable(false);
        notify = old;
    }