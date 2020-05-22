StringBuilder query = new StringBuilder();
query.append("begin\n");
things.forEach((thing) -> {
  query.append("delete edge owner from " + thing.getId() + "\n");
  query.append("create edge owner from " + thing.getId() + " to " + newOwner.getId() + "\n");
});
query.append("commit\n");

try {
  db.command(new OCommandScript(query)).execute()
} catch (Throwable t) {
  logger.error(t.toString());
}