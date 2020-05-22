public InputStream downloadDocument(String serverURL, String nomUtilisateur, String passwordUtilisateur, String path, String nomFile) {

Document newDocument = (Document) getSession(serverURL, nomUtilisateur, passwordUtilisateur).getObject(path);
    ContentStream cs = newDocument.getContentStream(null);


    return cs.getStream();
}