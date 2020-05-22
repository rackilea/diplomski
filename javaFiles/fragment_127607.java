//(assuming you have a ResultSet named RS)
Blob blob = rs.getBlob("SomeDatabaseField");

int blobLength = (int) blob.length();  
byte[] blobAsBytes = blob.getBytes(1, blobLength);

//release the blob and free up memory. (since JDBC 4.0)
blob.free();