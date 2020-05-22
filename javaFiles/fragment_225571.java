@Override
public void filter(ContainerRequestContext containerReqContext, ContainerResponseContext containerResponseContext) {
    //Adding temporary headers to read in WriterInterceptor
    containerResponseContext.getHeaders().add(
            "ClientId", containerReqContext.getProperty("ClientId"));
    containerResponseContext.getHeaders().add(
            "UserId", containerReqContext.getProperty("UserId"));
}