ByteArrayDataSource datasource = new ByteArrayDataSource(in, "multipart/form-data");
    MimeMultipart multipart = new MimeMultipart(datasource);

    int count = multipart.getCount();
    log.debug("count " + count);
    for (int i = 0; i < count; i++) {
        BodyPart bodyPart = multipart.getBodyPart(i);
        if (bodyPart.isMimeType("text/plain")) {
            log.info("text/plain " + bodyPart.getContentType());
            processTextData(bodyPart.getContent());
        } else if (bodyPart.isMimeType("application/octet-stream")) {
            log.info("application/octet-stream " + bodyPart.getContentType());
            processBinaryData(bodyPart.getInputStream()));
        } else {
            log.warn("default " + bodyPart.getContentType());
        }
    }