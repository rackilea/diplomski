HttpEntity entity = response.getEntity();
    if (entity != null) {
        InputStream instream = entity.getContent();
        while (instream.read(buf) >= 0) {
            if (cancelled)
               httpRequest.abort();
            // Process the file
        }
     }