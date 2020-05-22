public Component getTableCellRendererComponent(JTable table,
                                  Object value,
                                  boolean isSelected,
                                  boolean hasFocus,
                                  int row,
                                  int column) {
    Organizm o = (Organizm) value;
    setIcon((organizm == null) ? ikonkaPusty : organizm.rysowanie());
    return this;
}