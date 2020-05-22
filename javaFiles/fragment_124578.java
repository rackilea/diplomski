private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
      if(evt.getClickCount() == 2){
            AddProvince provinceDialog = new AddProvince();
            provinceDialog.setVisible(true);
            jTextField1.setText(provinceDialog.getSelectedProvince());
      }
}