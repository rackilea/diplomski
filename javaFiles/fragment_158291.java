AjaxLink openingLink = new AjaxLink("open")
{

  @Override
  public void onClick(AjaxRequestTarget target)
  {
    // Do something with model
    target.addComponent(content);
    dialog.open(target);
  }

};