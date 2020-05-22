String email = "ba@a.aa";
String userType = "JOB_SEEKER";
Transaction newTransaction = this.dgraphClient.newTransaction();
String triples = 
        "_:user <label> \"USER\" .\n" +
        "_:user <userType> \"" + email + "\" .\n" +
        "_:user <email> \"" + userType + "\" .";
Mutation mu =
    Mutation.newBuilder()
        .setSetNquads(ByteString.copyFromUtf8(triples))
        .build();
Assigned assigned = newTransaction.mutate(mu);