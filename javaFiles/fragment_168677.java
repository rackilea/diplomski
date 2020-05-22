JsonNode result = rsp1.thenAccept(rs -> return rs.asJson()).toCompletableFuture().get();

Boolean status = result.findPath("status").asBoolean();
if (status) {
   ...
}