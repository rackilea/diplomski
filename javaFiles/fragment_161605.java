public String jpost(Object requestEntity) throws ClientErrorException 
{
    return webTarget.path("jpost")
            .request(javax.ws.rs.core.MediaType.TEXT_PLAIN)
            .post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
}