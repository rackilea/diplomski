public class CustomButtonGroup extends ButtonGroup {
  @Override
  public void setSelected(ButtonModel model, boolean selected) {
    if (selected) {
      super.setSelected(model, selected);
    } else {
      clearSelection();
    }
  }
}