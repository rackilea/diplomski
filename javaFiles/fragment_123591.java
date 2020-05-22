try{
 if(table_po.getModel().getValueAt(0, 0)==null){
        JOptionPane.showMessageDialog(null, "Select products before saving");
        return;
  }
}catch(Exception e){ return; }