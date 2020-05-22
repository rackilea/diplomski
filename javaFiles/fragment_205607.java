else if (e.getSource() == clearButton) {
     txtMortgage.setText(""); 
     txtPayment.setText(""); 
     txtMortgage.requestFocusInWindow(); 
     loansList.setSelectedIndex(0);

     model.setRowCount(0); //!! added
  }