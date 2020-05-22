private void CustomRadioMouseReleased(java.awt.event.MouseEvent evt) {                                          

    CalabrioRadio.setSelected(con.getProp(CalabrioRadio.getText()));
    // The above line was changed
    System.out.println(con.getProp(CalabrioRadio.getText()));
}