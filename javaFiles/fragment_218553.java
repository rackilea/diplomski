public void actionPerformed(ActionEvent e)
{
  closeTab(component);
}

private void closeTab(JComponent component)
{
  menuTabbedPane.remove(component);
}