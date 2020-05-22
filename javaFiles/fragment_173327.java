try (   ByteArrayOutputStream baos = new ByteArrayOutputStream()   )
{
    [...]
    doc.save(baos);
    byte[] bytes = baos.toByteArray();

    [... set response content length property to bytes.length ...]

    response.getOutputStream().write(bytes);
}