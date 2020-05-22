public class EditableTreeItem extends TreeItem {
  public EditableTreeItem() {
    super();
    TextBox textBox = new TextBox();
    Button saveButton = new Button("Save");
    saveButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent e) {
        if (!textBox.getText().isEmpty()) {
          EditableTreeItem.this.setText(textBox.getText());
        }
      }
    });
  }
}