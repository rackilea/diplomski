public void startDownload(Garbage garbage) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    externalContext.setResponseHeader("Content-Type", garbage.getContentType());
    externalContext.setResponseHeader("Content-Length", garbage.getContent().length);
    externalContext.setResponseHeader("Content-Disposition", "attachment;filename=\"" + garbage.getFileName() + "\"");
    externalContext.getResponseOutputStream().write(garbage.getContent());
    facesContext.responseComplete();
}