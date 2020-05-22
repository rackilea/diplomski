List<File> attachments = new ArrayList<File>();
for (Message message : temp) {
    Multipart multipart = (Multipart) message.getContent();

    for (int i = 0; i < multipart.getCount(); i++) {
        BodyPart bodyPart = multipart.getBodyPart(i);
        if(!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
               StringUtils.isBlank(bodyPart.getFileName())) {
            continue; // dealing with attachments only
        } 
        InputStream is = bodyPart.getInputStream();
        // -- EDIT -- SECURITY ISSUE --
        // do not do this in production code -- a malicious email can easily contain this filename: "../etc/passwd", or any other path: They can overwrite _ANY_ file on the system that this code has write access to!
//      File f = new File("/tmp/" + bodyPart.getFileName());
        FileOutputStream fos = new FileOutputStream(f);
        byte[] buf = new byte[4096];
        int bytesRead;
        while((bytesRead = is.read(buf))!=-1) {
            fos.write(buf, 0, bytesRead);
        }
        fos.close();
        attachments.add(f);
    }
}