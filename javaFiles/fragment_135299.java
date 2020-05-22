private static final String SUCCESS = "attraction?includeViewParams=true";

...

if (FacesContext.getCurrentInstance().getMessageList().size() > 0) {
    return SUCCESS;
}