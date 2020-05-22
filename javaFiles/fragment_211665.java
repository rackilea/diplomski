Stage stage;
Stack stack; //scene2D.ui.Stack
Table mainTable;
Table overlayTable;

public GameScreen()
{
  stage = new Stage();
  stack = new Stack();
  mainTable = new Table();
  overlayTable = new overlayTable();

  stage.addActor(stack);
  stack.addActor(mainTable);
  stack.addActor(overlayTable);  
}