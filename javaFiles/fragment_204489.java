private File prepareAttachment(final MultipartFile mFile) throws IOException {
    File tmp = null;
    try {
        tmp = File.createTempFile("upload", ".tmp");
        mFile.transferTo(tmp);
        return tmp;
    } catch (IOException ioE) {
        if (tmp != null) {
            tmp.delete();
        }
        LOG.error("file has failed to upload.", ioE);
        throw ioE;
    }
}

MimeMessagePreparator preparator = new MimeMessagePreparator() {
    @Override
    public void prepare(final MimeMessage mimeMessage) throws Exception {
        File file1 = null;
        File file2 = null;
        try {
            file1 = prepareAttachment(form.getFile());
            file2 = prepareAttachment(form.getFile2());
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

            message.addAttachment(form.getFile().getOriginalFilename(), file1);
            message.addAttachment(form.getFile2().getOriginalFilename(), file2);
            // do your other stuff
        } catch (IOException e) {
            // some sort of error-handling, probably returning a message with an error status
        } finally {
            if (file1 != null) {
                file1.delete();
            }
            if (file2 != null) {
                file2.delete();
            }
        }
    }
};