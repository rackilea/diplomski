public static String stringify(Object object) {
    ObjectMapper jackson = new ObjectMapper();
    jackson.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    try {
        return jackson.writeValueAsString(object);
    } catch (Exception ex) {
        LOG.log(Level.SEVERE, "Error while creating json: ", ex);
    }
    return null;
}