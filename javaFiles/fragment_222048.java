@ManagedProperty(value="#{param.articleId}")
private Integer id;

@PostConstruct
public void initPostConstruct() {
    if (id == null) {
        String message = "No id specified in request";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
        return;
    }
    //use your service method to load the article
    //article = articleService.findById(id);
    //and add messages appropriately
}