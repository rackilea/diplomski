String[] headers = requestString.split("\n");
for (int i = 0; i < headers.length; i++) {
    if (headers[i].startsWith("Host")) {
        String[] hostHeader = headers[i].split(":");
        if (hostHeader.length > 1) {
            host = hostHeader[1];
        }
    }
 }