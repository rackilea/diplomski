Connection conn = dataSource.getConnection();
        for(int x = 0; x < byteFiles.size(); x++){
            Blob blob = conn.createBlob();
            blob.setBytes(1, byteFiles.get(x));
            fileBlobs.add(blob);
        }