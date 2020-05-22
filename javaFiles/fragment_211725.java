String contentType = connection.getHeaderField("Content-Type");
String charset = "UTF-8"; // Default to UTF-8
for (String param : contentType.replace(" ", "").split(";")) {
    if (param.startsWith("charset=")) {
        charset = param.split("=", 2)[1];
        break;
    }
}

String html = IOUtils.toString(input, charset);