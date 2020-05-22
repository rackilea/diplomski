table.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) { //or mouseReleased(MouseEvent e)
       if (SwingUtilities.isRightMouseButton(e)) {
           //-- select a row
           int idx = table.rowAtPoint(e.getPoint());
           table.getSelectionModel().setSelectionInterval(idx, idx);
           //---
           codeModel.setSelectedFileName(table.getValueAt(table.getSelectedRow(), 0).toString());
           JPopupMenu popup = createRightClickPopUp();
           popup.show(e.getComponent(), e.getX(), e.getY());
       }else{
           codeModel.setSelectedFileName(table.getValueAt(table.getSelectedRow(), 0).toString());
           codeTextArea.setText(codeModel.getCodeContents());
       }
   }
});