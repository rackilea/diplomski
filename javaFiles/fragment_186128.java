@GET
@Path("/common/{acc1}/{acc2}")
public String getCommon(@PathParam("acc1") String acc1, @PathParam("acc2") String acc2, @Context GraphDatabaseService db) throws IOException {
    try (Transaction tx = db.beginTx()) {
       String result = db.index().nodeIndexNames().toString();
       tx.success();
    }
}