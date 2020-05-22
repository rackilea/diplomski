private Item item;

public EditItemBean() {
    String id = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    this.item = someItemService.find(Long.valueOf(id));
}