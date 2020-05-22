public String login() {

    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

    try {
        request.login(this.userName, this.password);
        return "index?faces-redirect=true";
    } catch (Exception e) {
        return "error?faces-redirect=true";
    }