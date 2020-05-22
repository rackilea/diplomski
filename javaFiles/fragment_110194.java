if (required) {
    final String challenge = String.format(CHALLENGE_FORMAT, realm);
    throw new WebApplicationException(
                                    Response.status(Response.Status.UNAUTHORIZED)
                    .header(HttpHeaders.WWW_AUTHENTICATE, challenge)
                    .entity("Credentials are required to access this resource.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build());