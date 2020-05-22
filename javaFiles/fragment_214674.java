List<Long> simpleSizes = null;
try (   InputStream resource = GET_DOCUMENT_INPUTSTREAM) {
    simpleSizes = simpleApproach(resource);
}

if (1 < simpleSizes.size()) {
    try (   InputStream resource = GET_DOCUMENT_INPUTSTREAM;
            OutputStream file = new FileOutputStream("previousRevision.pdf")) {
        InputStream revision = ByteStreams.limit(resource, simpleSizes.get(simpleSizes.size() - 2));
        ByteStreams.copy(revision, file);
    }
}