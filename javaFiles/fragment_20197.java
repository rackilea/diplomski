public void sendPdf() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    externalContext.setResponseContentType("application/pdf");
    externalContext.setResponseHeader("Content-Disposition", "inline; filename=\"filename.pdf\"");
    yourJasperReportsClass.writePdfTo(externalContext.getResponseOutputStream());
    facesContext.responseComplete();
}