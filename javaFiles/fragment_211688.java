public static void main(final String... args) {
    final Gson gson = new Gson();

    out.println("deserialization:");
    final String incomingJson = "{someString:\"The answer\",someInt:43,clientData:{x:[1,1,2,3,5,8,13],y:[1,1,2,6,24,120],tonsOfComplicatedStuff:{stuff:stuff}}}";
    final MyEntity myEntity = gson.fromJson(incomingJson, MyEntity.class);
    out.println("\t" + myEntity.someString);
    out.println("\t" + myEntity.someInt);
    out.println("\t" + myEntity.clientData);

    out.println("serialization:");
    final String outgoingJson = gson.toJson(myEntity);
    out.println("\t" + outgoingJson);

    out.println("equality check:");
    out.println("\t" + areEqual(gson, incomingJson, outgoingJson));
}

private static boolean areEqual(final Gson gson, final String incomingJson, final String outgoingJson) {
    final JsonElement incoming = gson.fromJson(incomingJson, JsonElement.class);
    final JsonElement outgoing = gson.fromJson(outgoingJson, JsonElement.class);
    return incoming.equals(outgoing);
}