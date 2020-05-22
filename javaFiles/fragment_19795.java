private static Object facesContext() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (context == null)
        return "No Jsf Context";
    if (context instanceof PrimeFacesContext)
        return ((PrimeFacesContext) context).getWrapped();
    return context;
}