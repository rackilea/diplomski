public Response getDomainGroups(@PathParam("ownerID") String ownerID) {
    WebResource r = client.resource(URL_BASE + "/" + URL_GET_GROUPS + "/" + ownerID);
    ClientResponse resp = r.get(ClientResponse.class);
    return clientResponseToResponse(resp);
}

public static Response clientResponseToResponse(ClientResponse r) {
    // copy the status code
    ResponseBuilder rb = Response.status(r.getStatus());
    // copy all the headers
    for (Entry<String, List<String>> entry : r.getHeaders().entrySet()) {
        for (String value : entry.getValue()) {
            rb.header(entry.getKey(), value);
        }
    }
    // copy the entity
    rb.entity(r.getEntityInputStream());
    // return the response
    return rb.build();
}