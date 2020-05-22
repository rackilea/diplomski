public void callServlet(Long id) throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    String uuid = UUID.randomUUID().toString();
    ec.getSessionMap().put(uuid, id);
    ec.redirect("MyServlet?id=" + uuid);
}