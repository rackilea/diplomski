response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
OutputStream output = response.getOutputStream();

String acceptEncoding = request.getHeader("Accept-Encoding");
if (acceptEncoding != null && acceptEncoding.contains("gzip")) {
    response.setHeader("Content-Encoding", "gzip");
    output = new GZIPOutputStream(output);
}

output.write(json.getBytes("UTF-8"));