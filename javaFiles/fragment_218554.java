public Tab(String label, final JComponent component)
{
  ...
  closeTab.addActionListener(new ActionListner()
  {
    public void actionPerformed(ActionEvent e)
    {
      closeTab(component);
    }
  });
  ...
}