FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest origRequest = (HttpServletRequest)context.getExternalContext().getRequest();
    contextPath = origRequest.getContextPath();
try {
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect(contextPath  + "/faces/OpenedAccountsProductTypeLevel.xhtml");
    } catch (IOException e) {
        e.printStackTrace();
    }