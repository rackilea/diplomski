Blob blob = blobStore.blobBuilder(file.getName())
    .payload(fileBytes)
    .contentLength(file.length()
    .contentType(contentType)
    .userMetadata(ImmutableMap.of("test", String.valueOf(strValue)))
    .build();