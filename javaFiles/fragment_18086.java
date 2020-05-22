public Email addAttachment(String name, File file) throws IOException, FileNotFoundException {
        return this.addAttachment(name, new FileInputStream(file));
    }

    public Email addAttachment(String name, String file) throws IOException {
        return this.addAttachment(name, new ByteArrayInputStream(file.getBytes()));
    }

    public Email addAttachment(String name, InputStream file) throws IOException {
        this.attachments.put(name, file);
        return this;
    }