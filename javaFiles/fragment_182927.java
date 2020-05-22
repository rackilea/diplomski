MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8") {

    @Override
    public void addInline(String contentId, Resource resource) throws MessagingException {
        Assert.notNull(resource, "Resource must not be null");
        String contentType = this.getFileTypeMap().getContentType(resource.getFilename());
        contentType = contentType.replace("x-png", "png");
        this.addInline(contentId, resource, contentType);

    }
};