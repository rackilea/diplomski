list.addListSelectionListener(new ListSelectionListener()
{
  public void valueChanged(ListSelectionEvent event)
  {
    if (!event.getValueIsAdjusting())
    {
      String selection = (String) list.getSelectedValue();
      System.out.println(selection);
    }
  }
});