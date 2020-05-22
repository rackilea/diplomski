item.add(myLink = new AjaxLink<String>("extenderInstitut") {
  private static final long serialVersionUID = 1L;

  @Override
  public void onClick(AjaxRequestTarget target) {
    collapseItem(index, item, div);
    target.add(mainForm);
  }
});