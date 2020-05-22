Map<String, String> respHeaders =
                   (Map<String, String>) request.getAttribute("respHeaders");
for (String key : respHeaders.keySet()) {
    response.setHeader(key, respHeaders.get(key)); // set response headers
}

String sendRedirect;
if ((sendRedirect = (String) request.getAttribute("sendRedirect")) != null) {
    response.sendRedirect(sendRedirect); // redirect the client
}