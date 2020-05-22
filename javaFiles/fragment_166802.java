String fileName = "gadže zèleno_iscusinţă.pdf";

String encodeFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");

ctx.response()
        .putHeader(HttpHeaders.CONTENT_TYPE, contenype)
        .putHeader("Content-Disposition", encodeFileName)
        .putHeader(HttpHeaders.TRANSFER_ENCODING, "chunked")
        .sendFile(filePath).end();