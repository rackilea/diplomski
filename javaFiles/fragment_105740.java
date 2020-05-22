if (scheme.equals("file") || scheme.equals("jar")) {
    InputStream stream = getInputStream(uri);
    stream.close();
    isConnected = true;
    contentType = MediaUtils.filenameToContentType(uriString); // We need to provide at least something
}

if (isConnected) {
    // Check whether content may be played.
    // For WAV use file signature, since it can detect audio format
    // and we can fail sooner, then doing it at runtime.
    // This is important for AudioClip.
    if (MediaUtils.CONTENT_TYPE_WAV.equals(contentType)) {
        contentType = getContentTypeFromFileSignature(uri);
        if (!MediaManager.canPlayContentType(contentType)) {
            isMediaSupported = false;
        }
    } else {
        if (contentType == null || !MediaManager.canPlayContentType(contentType)) {
            // Try content based on file name.
            contentType = MediaUtils.filenameToContentType(uriString);

            if (Locator.DEFAULT_CONTENT_TYPE.equals(contentType)) {
                // Try content based on file signature.
                contentType = getContentTypeFromFileSignature(uri);
            }

            if (!MediaManager.canPlayContentType(contentType)) {
                isMediaSupported = false;
            }
        }
    }

    // Break as connection has been made and media type checked.
    break;
}