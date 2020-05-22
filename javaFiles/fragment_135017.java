String intranetURL = "http://intranet.com";
String internetURL = "http://example.com/proxy";

if (request.getRequestURI().endsWith(".html")) { // A HTML page is requested.
    Document document = Jsoup.connect(intranetURL + request.getPathInfo()).get();

    for (Element element : document.select("[href]")) {
        element.attr("href", element.absUrl("href").replaceFirst(intranetURL, internetURL));
    }

    for (Element element : document.select("[src]")) {
        element.attr("src", element.absUrl("src").replaceFirst(intranetURL, internetURL));
    }

    response.setContentType("text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    resposne.getWriter().write(document.html());
}
else { // Other resources like images, etc.
    URLConnection connection = new URL(intranetURL + request.getPathInfo()).openConnection();

    for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
        for (String value : header.getValue()) {
            response.addHeader(header.getKey(), value);
        }
    }

    InputStream input = connection.getInputStream();
    OutputStream output = response.getOutputStream();
    // Now just copy input to output.
}