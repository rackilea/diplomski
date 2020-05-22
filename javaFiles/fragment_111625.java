if (!this.expectReply) {
    return null;
}

if (resultFile != null) {
    if (originalFileFromHeader == null && payload instanceof File) {
        return this.getMessageBuilderFactory().withPayload(resultFile)
                    .setHeader(FileHeaders.ORIGINAL_FILE, payload);
    }
}
return resultFile;