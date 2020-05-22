private void addSeverityError(String message)
{
    FacesContext context = FacesContext.getCurrentInstance();
    FacesMessage fMessage = new FacesMessage();
    fMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
    fMessage.setSummary(message);
    fMessage.setDetail("Validation error");
    context.addMessage("nonExistClient", fMessage);
}