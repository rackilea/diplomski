try {
    (...)
} catch(ResourceException ex) {
    Representation responseRepresentation
           = clientResource.getResponseEntity();
    JsonRepresentation jsonRepr
           = new JsonRepresentation(responseRepresentation);
    JSONObject errors = jsonRepr.getJsonObject();
}