JWTAuth authProvider = JWTAuth.create(vertx, new JWTAuthOptions(new JsonObject()
.put("permissionsClaimKey", "realm_access/roles")
.put("pubSecKeys", new JsonArray()
   .add(new JsonObject()
      .put("publicKey", "...")
      .put("type", "RS256")))));