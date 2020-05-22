private void processAttachment(final Multipart multipart) {

    try {
        for (int i = 0; i < multipart.getCount(); i++) {
            final BodyPart bodyPart = multipart.getBodyPart(i);

// BEGIN - Added this part
            System.out.println("CLASS bodyPart: " + bodyPart.getContent().getClass());

            if (bodyPart.getContent() instanceof IMAPNestedMessage) {
                processMessage((IMAPNestedMessage) bodyPart.getContent());
            } else {
// END - Added this part
                if (bodyPart.getContent() instanceof Multipart) {
                    processAttachment((Multipart) bodyPart.getContent());
                } else {
                    final boolean isXml = bodyPart.getFileName() != null && isXmlType(bodyPart.getContentType());
                    if (isXml) {
                        final InputStream inputStream = getReusableInputStream(bodyPart);
                        processXMLAttachment(inputStream);
                    }
                }
            }

        }
    } catch (final Exception e) {
        sendMailService.sendMailForImportINPSFailed("metodo processAttachment()", e);
        e.printStackTrace();
    }

}