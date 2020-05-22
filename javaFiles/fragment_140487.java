public void submit() throws IOException {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpSession session = (HttpSession) externalContext.getSession(true);
    String url = request.getRequestURL().append(";jsessionid=").append(session.getId()).toString();

    Document doc = Jsoup.connect(url).get();
    String html = doc.select("#wrapper").html();
    // ...
}