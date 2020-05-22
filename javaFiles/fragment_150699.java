@PostConstruct
public void init() {
    if (!FacesContext.getCurrentInstance().isPostback()) {
        // ...
    }
}