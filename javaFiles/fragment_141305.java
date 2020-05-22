private String getRequestURL(){
    HttpServletRequest request = (HttpServletRequest)FacesContext.getExternalContext().getRequest();
    return request.getRequestURL();
  }

  private boolean isDraft() {
    return getRequestURL().contains(DRAFT_URL_IDENTIFIER);
  }