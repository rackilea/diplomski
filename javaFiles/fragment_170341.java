private HttpEntity makeAllUppercase(final HttpEntity entity)
{
    Header h = entity.getContentType();
    ContentType contentType = h != null ? ContentType.parse(h.getValue()) : ContentType.DEFAULT_TEXT;
    String content = EntityUtils.toString(entity, contentType.getCharset());
    return new StringEntity(content.toUpperCase(Locale.US), contentType);
}