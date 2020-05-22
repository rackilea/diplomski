String id = "searchInput";
final TextField<String> searchInput = new TextField<String>(id, model);
searchInput.setMarkupId(id);

searchInput.add(new AjaxFormComponentUpdatingBehavior("onfocus") {
  @Override
  protected void onUpdate(final AjaxRequestTarget target) {
    System.out.print("never saw that message :(");
    searchInput.setDefaultModelObject("");
    target.setOutputMarkupId(true);
    target.addComponent(searchInput);
  }
});