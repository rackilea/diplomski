public class MyFilter implements ContainerResponseFilter {

    @Override
    public void filter(
        ContainerRequest request,
        ContainerResponse response
    ) throws IOException {
        request.getHttpHeaders().add(<header name>, <header value>);
    }
}