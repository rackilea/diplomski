import oracle.jdbc.OracleConnection;

// ...

        OracleConnection conn = dataSource.getConnection().unwrap(OracleConnection.class);

        List<Blob> fileBlobs = new ArrayList<>();
        for(int x = 0; x < byteFiles.size(); x++){
            Blob blob = conn.createBlob();
            blob.setBytes(1, byteFiles.get(x));
            fileBlobs.add(blob);
        }

        Array array = conn.createOracleArray("BLOB_ARRAY",
            fileBlobs.toArray(new Blob[fileBlobs.size()]));

        CallableStatement cstmt = conn.prepareCall("{? = call insertFiles(?, ?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setInt(2, userId);
        cstmt.setArray(3, array);

        cstmt.execute();

        int result = cstmt.getInt(1);