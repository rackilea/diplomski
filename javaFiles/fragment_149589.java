private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    if(jsonNode == null){
        out.writeBoolean(false);
    } else {
        out.writeBoolean(true);
        new ObjectMapper().configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false).writeValue(out, jsonNode);
    }
}

private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    if(in.readBoolean()){
        this.jsonNode = new ObjectMapper().configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false).readValue(in, JsonNode.class);
    }     
}