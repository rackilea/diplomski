public static void loadAll(final JComboBox comboBox) {
    try {
        final List<Combo> comboList = ComboBoxController.getComboType();
        final DefaultComboBoxModel dtm = (DefaultComboBoxModel) comboBox.getModel();

        dtm.removeAllItems();

        for (final Combo combo : comboList) {
            dtm.addElement(combo.getComboType());
        }
    } catch (final SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AllComboBoxMethod.class.getName()).log(Level.SEVERE, null, ex);
    }
}