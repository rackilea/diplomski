EventHandler<MouseEvent> onMouseExitedHandler = new EventHandler<MouseEvent>()
{
  @Override
  public void handle(MouseEvent event)
  {
    System.out.println(editor.getHtmlText());
  }
};

for (Node node : editor.lookupAll("ToolBar"))
{
  node.setOnMouseExited(onMouseExitedHandler);
}