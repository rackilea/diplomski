private class MyCellRender extends DefaultListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
       super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
       if(value.toString().contains("INCOMPLETE") ||  value.toString().contains("COMPLETED")) {
           Color fg = value.toString().contains("COMPLETED") ? Color.green : Color.red;
           setForeground(fg);
       } else {
           setForeground(list.getForeground());
       }
       return this;
   }
}