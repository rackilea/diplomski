col.setLabelProvider(new ColumnLabelProvider() {
  @Override
  public String getText(Object element) {
    return null;
  }

  @Override
  public Image getImage(Object element) {
    if (((Person) element).isMarried()) {
      return CHECKED;
    } else {
      return UNCHECKED;
    }
  }
});