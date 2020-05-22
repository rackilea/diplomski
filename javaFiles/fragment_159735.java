getJdbcTemplate().query(getFileContentSql, new RowMapper<Void>() {
    public void mapRow(ResultSet rs, int rowNum) throws SQLException {
        OracleLobHandler lobHandler = new OracleLobHandler();
        InputStream inputStream = lobHandler.getBlobAsBinaryStream(rs, "file_content");
        ExlImporter importer = new ExlBOMImporter(inputStream);
        importer.process();
    }
}, fileId);