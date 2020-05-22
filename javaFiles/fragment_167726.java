......................
 while(rs.next()) {
    objRT_DownLoadAttachDTO = new LM_DownLoadAttachDto();
    objRT_DownLoadAttachDTO.setName(rs.getString("ATTACH_NAME"));
    BLOB b = (oracle.sql.BLOB)rs.getBlob("ATTACH_FILE");        
    Blob bb =rs.getBlob("ATTACH_FILE");        
    objRT_DownLoadAttachDTO.setblob((oracle.sql.BLOB)  rs.getBlob("ATTACH_FILE"));          
    oracle.sql.BLOB bbb = (oracle.sql.BLOB)rs.getBlob("ATTACH_FILE");
    l =bbb.length();
    byte[] ba =blob.getBytes(1,(int)bbb.length());
 }
.................