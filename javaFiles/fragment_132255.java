@Provider
@PreMatching
public class ContentTypeFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {
        MultivaluedMap<String,String> headers=requestContext.getHeaders();
        List<String> contentTypes=headers.remove(HttpHeaders.CONTENT_TYPE);
        if (contentTypes!=null && !contentTypes.isEmpty()){
            String contentType= contentTypes.get(0);
            String sanitizedContentType=contentType.replaceFirst(";.*", "");
            headers.add(HttpHeaders.CONTENT_TYPE, sanitizedContentType);
        }
    }
}