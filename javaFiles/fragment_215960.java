private void searchActionListener(ActionEvent event) {
    btnSearch.setEnabled(false);  // user should not be able to search while it's running

    // extract Swing data before running outside the EDT
    String query = txtSearch.getText()
    boolean useName = chkName.isSelected();
    boolean useAddress = chkAddress.isSelected();
    // ... and so on

    // do work OUTSIDE the EDT
    ForkJoinPool.commonPool().execute(() -> {
      Result result = business.find(query, useName, useAddress);
      SwingUtilities.invokeLater(() -> {
        processResult(result); // do whatever is needed
        btnSearch.setEnabled(true);
      });
    });
  }