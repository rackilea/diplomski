/**
   * Return an int containing the wrapped line index at the given position
   * @param component JTextPane
   * @param int pos
   * @return int
   */
  public int getLineNumber(JTextPane component, int pos) 
  {
    int posLine;
    int y = 0;

    try
    {
      Rectangle caretCoords = component.modelToView(pos);
      y = (int) caretCoords.getY();
    }
    catch (BadLocationException ex)
    {
    }

    int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
    posLine = (y / lineHeight) + 1;
    return posLine;
  }