public class MyDialogBox extends DialogBox {
  private final TextBox firstName;
  private final TextBox surName;
  public MyDialogBox() {
    firstName = new TextBox();
    surName = new TextBox();

    DialogGrid dialogGrid = new Grid(2, 3);
    // do all your stuff with the grid, add TextBoxes, etc.
    add(dialogGrid);

    setAutoHideEnabled(true);
    // set all the properties of your DialogBox
  }

  public TextBox getFirstNameTextBox() {
    return firstName;
  }
  // same with surName...
}