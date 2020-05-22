public void propertyChange(PropertyChangeEvent event) {
  super.propertyChange(event);
  if (event.getSource() == combo1)
  {
    if (combo1.getSelectedValue().equals("Some Value"))
    {
      combo2.setSelectedValue("Some Other Value");
    }
  }
}