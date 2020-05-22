public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        final JComboBox comboBox = (JComboBox) e.getSource();
        final Object repeatedSelectedItem = comboBox.getSelectedItem();
        if (repeatedSelectedItem != null
                && repeatedSelectedItem.equals("(Custom..)")) {
            SwingUtilities.invokeLater(new Runnable() {
                  public void run() {
                      invokeCustomFilterDialog(repeatedSelectedItem, comboBox);
                  }
            });

        }
    }