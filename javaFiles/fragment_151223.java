@PostMapping(path = "/abc")
public String createAbc(HttpServletRequest request) throws IOException {
    StringBuilder builder = new StringBuilder();
    try (BufferedReader in = request.getReader()) {
        char[] buf = new char[4096];
        for (int len; (len = in.read(buf)) > 0; )
            builder.append(buf, 0, len);
    }
    String requestBody = builder.toString();
    logger.info("Request body: " + requestBody);
    return "abc";
}