String file = request.getRequestURI();
if (request.getQueryString() != null) {
   file += '?' + request.getQueryString();
}
URL reconstructedURL = new URL(request.getScheme(),
                               request.getServerName(),
                               request.getServerPort(),
                               file);
reconstructedURL.toString();