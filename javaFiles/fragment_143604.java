dbName = JOptionPane.showInputDialog(requestDBName);
    if(dbName!=null){
      OptionPane.showMessageDialog(null, successfullyConnected + dbName);
    } else {
      OptionPane.showMessageDialog(null, "Please choise one database");
    }