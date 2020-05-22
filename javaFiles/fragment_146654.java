table.getTableHeader().addMouseListener(new MouseAdapter() {

   @Override
   public void mouseClicked(MouseEvent e) {
     super.mouseClicked(e); 
     JTableHeader header = (JTableHeader)(e.getSource());  
     JTable tableView = header.getTable();  
     TableColumnModel columnModel = tableView.getColumnModel();  
     int viewColumn = columnModel.getColumnIndexAtX(e.getX()); 

      if(columnModel.getColumn(viewColumn).getIdentifier().equals("bColumnID"))
      {
          JOptionPane.showMessageDialog(null, "Hi bColumnID header is clicked");
      }

      }


});