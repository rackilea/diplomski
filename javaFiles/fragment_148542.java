@Override
public void filter(ContainerRequestContext requestContext) {
    ContainerRequest containerRequest = (ContainerRequest)requestContext;
    containerRequest.bufferEntity();
    Order order = containerRequest.readEntity(Order.classs);
    // or
    InputStream in = containerRequest.readEntity(InputStream.class);
}