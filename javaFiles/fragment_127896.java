table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
     @Override
     public void valueChanged(ListSelectionEvent e) {
          if (e.getValueIsAdjusting()) {
               tabs.setSelectedIndex(tabs.indexOfTab("Other Panel"));
          }
     }
});