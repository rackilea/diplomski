HttpEntity entity = response.getEntity();
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
        entity.writeTo(os);
    } catch (IOException e1) {
    }
    String contentString = new String(os.toByteArray());