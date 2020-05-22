class ClientResponseLoggingFilter implements ClientResponseFilter {

    @Override
    public void filter(final ClientRequestContext reqCtx,
                       final ClientResponseContext resCtx) throws IOException {

        if ( resCtx.getStatus() == Response.Status.BAD_REQUEST.getStatusCode() ) {
            throw new MyClientException( resCtx.getStatusInfo() );
        }

        ...