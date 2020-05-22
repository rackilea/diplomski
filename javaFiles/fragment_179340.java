public class EditorContributor extends EditorActionBarContributor
{
  private IEditorPart activeEditorPart = null;

  @Override
  public void setActiveEditor(IEditorPart targetEditor)
  {
    if (activeEditorPart == targetEditor)
      return;

    activeEditorPart = targetEditor;

    if (targetEditor instanceof MyEditor) {
        IActionBars actionBars = getActionBars();

        actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);
        // ... more global action handlers
    }
  }
}