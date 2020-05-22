File image = new File("d:\\image\1.jpg");
    response.setBufferSize(DEFAULT_BUFFER_SIZE);
    response.setContentType(contentType);
    response.setHeader("Content-Length", String.valueOf(image.length()));
    response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");

    BufferedInputStream input = null;
    BufferedOutputStream output = null;

    try {
        // Open streams.
        input = new BufferedInputStream(new FileInputStream(image), DEFAULT_BUFFER_SIZE);
        output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

        // Write file contents to response.
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int length;
        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
    } finally {
        // Gently close streams.
        close(output);
        close(input);
    }