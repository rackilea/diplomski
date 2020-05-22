private class ImgListCellRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
     if (value != null) {
        BufferedImage img = ((SimpleTnWrapper) value).getTnImage();

        value = new ImageIcon(img); // *** change value parameter to an ImageIcon 
     }
     return super.getListCellRendererComponent(list, value, index,
           isSelected, cellHasFocus);
  }

}

private class NonImgCellRenderer extends DefaultListCellRenderer {
  @Override
  public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {

     // all this does is use the item held by the list, here value
     // to extract a String that I want to display
     if (value != null) {
        SimpleTnWrapper simpleTn = (SimpleTnWrapper) value;
        String displayString = simpleTn.getImgHref().getImgHref();
        displayString = displayString.substring(displayString.lastIndexOf("/") + 1);

        value = displayString;  // change the value parameter to the String ******
     }
     return super.getListCellRendererComponent(list, value, index,
           isSelected, cellHasFocus);
  }      
}