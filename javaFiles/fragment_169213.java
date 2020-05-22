@Override
public void filter(ContainerRequestContext requestContext) throws IOException {
    try {
        ContainerRequest cr = (ContainerRequest) requestContext;
        cr.bufferEntity();
        final UserFriendsBaseModel bm = cr.readEntity(UserFriendsBaseModel.class);