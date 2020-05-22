try {
    processAndSaveInMemoryOrTempDiskFile(someData, byteArrayOrFileLocation);
} catch (SomeException e) {
    throw new ServletException(e, "Processing some data failed.");
}

copyFromMemoryOrTempDiskToResponse(byteArrayOrFileLocation, writer);