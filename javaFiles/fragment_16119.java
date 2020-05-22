private static void enableButtonGroup(ButtonGroup buttonGroup, boolean enable)
{
  Enumeration<AbstractButton> buttons = buttonGroup.getElements();
  while (buttons.hasMoreElements())
  {
    buttons.nextElement().setEnabled(enable);
  }
}