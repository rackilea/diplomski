StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(request.getInputStream(), writer);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read input stream");
        }