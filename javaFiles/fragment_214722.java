protected void onInit() {
    Assert.notNull(directory, "'directory' must not be null");
    if (!this.directory.exists() && this.autoCreateDirectory) {
        this.directory.mkdirs();
    }
    Assert.isTrue(this.directory.exists(),
            "Source directory [" + directory + "] does not exist.");