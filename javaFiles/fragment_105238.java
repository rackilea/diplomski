InputStream inputStream = httpServletRequest.getInputStream();

int contentLength = -1; // fake, will be ignored anyway
SqlLobValue sqlLobValue = new SqlLobValue(
    inputStream,
    contentLength,
    new DefaultLobHandler() {
        public LobCreator getLobCreator() {
            return new DefaultLobHandler.DefaultLobCreator() {
                public void setBlobAsBinaryStream(PreparedStatement ps, int paramIndex, InputStream binaryStream, int contentLength) throws SQLException {
                    // The contentLength parameter should be the -1 we provided earlier.
                    // You now have direct access to the PreparedStatement.
                    // Simply avoid calling setBinaryStream(int, InputStream, int)
                    // in favor of setBinaryStream(int, InputStream).
                    ps.setBinaryStream(paramIndex, binaryStream);
                }
            };
        }
    }
);

jdbcTemplate.update(
    "INSERT INTO foo (bar) VALUES (?)",
    new Object[]{ sqlLobValue }
);