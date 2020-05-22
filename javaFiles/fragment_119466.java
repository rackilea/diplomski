Connection connection = Jsoup.connect(linkInfo.getLink())
    .method(Connection.Method.HEAD)
    .validateTLSCertificates(false)
    .followRedirects(false)
    .userAgent(USER_AGENT);

Connection.Response head = connection.execute();
if (!head.contentType().contains("text/html")) return;

Document html = Jsoup.connect(head.url())
    .validateTLSCertificates(false)
    .followRedirects(false)
    .userAgent(USER_AGENT)
    .get();