HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
ByteArrayOutputStream outputStream = null;

try {
    outputStream = //Call service to generate the extract, return outputStream ; 
    if(outputStream != null){
    response.setContentType(T3Constants.MIME_ZIP);
    response.setHeader(T3Constants.CONTENT_DISPOSITION, ATTACH_FILE_NAME);
    response.getOutputStream().write(outputStream.toByteArray());
    response.flushBuffer();
    FacesContext.getCurrentInstance().responseComplete();
    outputStream.close();
    } else {
    formatFacesMessage(FacesMessage.SEVERITY_WARN, "No data for selected filter", "No data for selected filter");
    }
}