public void downloaddoc(Document doc) throws FileNotFoundException, TransformerConfigurationException, TransformerException {

InputStream input = downloaddoc(serverUrl, username, password, doc.getPath(), doc.getNameFile);

ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(doc.getNomRepertoire()), doc.getNomRepertoire()));

}