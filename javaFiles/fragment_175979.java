try (Connection hikariCon = dbConnect.getConnection()) {
   if (hikariCon.isWrapperFor(OracleConnection.class)) {
      OracleConnection connection = hikariCon.unwrap(OracleConnection.class);
      :
      :
   }